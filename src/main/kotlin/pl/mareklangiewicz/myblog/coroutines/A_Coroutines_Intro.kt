package pl.mareklangiewicz.myblog.coroutines

import io.reactivex.Flowable
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.future.await
import kotlinx.coroutines.experimental.future.future
import org.junit.Ignore
import org.junit.Test
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.experimental.*

/**
 * Kotlin Coroutines Intro in "TDD" (kind of..)
 *
 * This is my attempt to learn about kotlin coroutines and write some tests on the way.
 *
 * The content here is based on [Coroutines Guide](https://github.com/Kotlin/kotlinx.coroutines/blob/master/coroutines-guide.md)
 * but here it is both: **documentation** and **runnable code** in **one place**.
 */
class A_Coroutines_Intro {

    /**
     * Current system time as a string
     *
     * @return current time as a string with milliseconds
     */
    fun getCurrentTimeString() = System.currentTimeMillis().let { String.format(Locale.US, "%tT:%tL", it, it) }

    /**
     * Print given string with "Coroutines Intro" prefix and with current time in square brackets
     */
    val Any.p get() = println("Coroutines Intro [${getCurrentTimeString()}] $this")

    /**
     * First coroutine
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.A_basics
     */
    @Test
    fun A_basics() {
        launch(CommonPool) {
            delay(1000L)
            "World!".p
        }
        "Hello,".p
        Thread.sleep(2000L)

    }
    // TODO: write explanation, write about this mixing sleep and delay


    // TODO: CommonPool, Executors, Contexts (and Elements)


    // TODO: about runblocking, coroutine dispatcher?, interruptions?, coroutinescope?
    // TODO: CoroutineScope looks important to dig into
    /**
     * Bridging blocking and nonblocking worlds
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.B_runBlocking
     */
    @Test
    fun B_runBlocking() {
        runBlocking {
            delay(1000)
            "1000".p
            delay(1000)
            "2000".p
            delay(1000)
            "3000".p
        }
    }

    private fun sample(block: suspend CoroutineScope.() -> Unit): Unit = runBlocking { block() }

    /**
     * Some convention for future samples/experiments/tests
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.C_sampleConvention
     */
    @Test fun C_sampleConvention() = sample {
        delay(1000)
        "1000".p
        delay(1000)
        "2000".p
    }

    /**
     * Use Job class to handle coroutine state and to wait (non blocking) for it to finish
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.D_introduceJob
     */
    @Test fun D_introduceJob() = sample {
        val job = launch(CommonPool) {
            delay(1000L)
            "World!".p
        }
        "Hello,".p
        job.join() // this suspending function (join) waits for job to finish

    }

    // TODO LATER: about cancellation

    /**
     * Extract suspending function
     *
     * This throws an exception (see documented errors in next examples - under the hood 2, 3..)
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.E_extractSuspendingFunction
     */
    @Ignore @Test fun E_extractSuspendingFunction() = sample {
        val job = launch(CommonPool) {
            delayAndPrintWorld()
        }
        "Hello,".p
        job.join() // this suspending function (join) waits for job to finish

    }

    /**
     * Extracted fun delayAndPrintWorld
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.delayAndPrintWorld
     */
    suspend fun delayAndPrintWorld() {
        delay(1000L)
        "World!".p
    }

    /**
     * Run 100 000 coroutines in parallel
     *
     * Coroutines are extremely lightweight so we can start **A LOT** of them
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.F_coroutinesAreLightweight
     */
    @Test fun F_coroutinesAreLightweight() = sample {
        val jobs = List(100_000) {
            // create a lot of coroutines and list their jobs
            launch(CommonPool) {
                delay(1000L)
                print(".")
            }
        }
        jobs.forEach { it.join() } // wait for all jobs to complete
    }

    /**
     * Active coroutines are terminated when the whole process ends (like daemon threads)
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.G_exitWhileCoroutineStillActive
     */
    @Ignore @Test fun G_exitWhileCoroutineStillActive() = sample {
        launch(CommonPool) {
            repeat(1000) { i ->
                "I'm sleeping $i ...".p
                delay(500L)
            }
        }
        delay(1300L) // just quit after delay
    }

    /**
     * Cancel coroutine with Job.cancel
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.H_cancelJobCorrectly
     */
    @Test fun H_cancelJobCorrectly() = sample {
        val job = launch(CommonPool) {
            repeat(1000) { i ->
                "I'm sleeping $i ...".p
                delay(500L)
            }
        }
        delay(1300L) // delay a bit
        "main: I'm tired of waiting!".p
        job.cancel() // cancels the job
        delay(1300L) // delay a bit to ensure it was cancelled indeed
        "main: Now I can quit.".p
    }

    /**
     * Cancellation is cooperative 1
     *
     * This example shows that we can not cancel coroutine that doesn't listen
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.I_cancellationIsCooperative_1
     */
    @Test fun I_cancellationIsCooperative_1() = sample {
        val job = launch(CommonPool) {
            var nextPrintTime = 0L
            var i = 0
            while (i < 10) { // computation loop
                val currentTime = System.currentTimeMillis()
                if (currentTime >= nextPrintTime) {
                    "I'm sleeping ${i++} ...".p
                    nextPrintTime = currentTime + 500L
                }
            }
        }
        delay(1300L) // delay a bit
        "main: I'm tired of waiting!".p
        job.cancel() // cancels the job
        delay(1300L) // delay a bit to see if it was cancelled....
        "main: Now I can quit.".p
    }

    /**
     * Cancellation is cooperative 2
     *
     * This example shows that we can cancel coroutine using isActive property from [CoroutineScope]
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.I_cancellationIsCooperative_2
     */
    @Test fun I_cancellationIsCooperative_2() = sample {
        val job = launch(CommonPool) {
            var nextPrintTime = 0L
            var i = 0
            while (isActive) { // computation loop
                val currentTime = System.currentTimeMillis()
                if (currentTime >= nextPrintTime) {
                    "I'm sleeping ${i++} ...".p
                    nextPrintTime = currentTime + 500L
                }
            }
        }
        delay(1300L) // delay a bit
        "main: I'm tired of waiting!".p
        job.cancel() // cancels the job
        delay(1300L) // delay a bit to see if it was cancelled....
        "main: Now I can quit.".p
    }

    /**
     * Under the hood test
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.J_underTheHood_1
     */
    @Test
    fun J_underTheHood_1() {
        val coroutine: suspend Unit.() -> Unit = {
            "coroutine start".p
            delay(1000)
            "coroutine middle".p
            delay(1000)
            "coroutine end".p
        }

        val completion = object : Continuation<Unit> {
            override val context = EmptyCoroutineContext
            override fun resume(value: Unit) {
                "completion: completed normally".p
            }

            override fun resumeWithException(exception: Throwable) {
                "completion: exception: $exception".p
            }
        }

        "main: start".p
        coroutine.startCoroutine(Unit, completion)
        "main: after startCoroutine".p
        Thread.sleep(3000)
        "main: after sleep 3000".p
    }

    val myscheduler = Executors.newSingleThreadScheduledExecutor()

    /**
     * Simple suspending function implementation
     *
     * Important: the "return" keyword (or expression body syntax) is necessary here.
     * Without "return" it returns from suspension more than once.. looks like bug in state machine generation
     */
    suspend fun mydelay(time: Long): Unit {
        return suspendCoroutine<Unit> { continuation ->
            myscheduler.schedule({ continuation.resume(Unit) }, time, TimeUnit.MILLISECONDS)
        }
    }


    /**
     * Under the hood test 2 without using kotlinx stuff
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.J_underTheHood_2
     */
    @Test
    fun J_underTheHood_2() {

        val coroutine: suspend () -> Unit = {
            "coroutine start".p
            mydelay(1000)
            "coroutine middle".p
            mydelay(1000)
            "coroutine end".p
        }

        val completion = object : Continuation<Unit> {
            override val context = EmptyCoroutineContext
            override fun resume(value: Unit) {
                "completion: completed normally".p
            }

            override fun resumeWithException(exception: Throwable) {
                "completion: exception: $exception".p
            }
        }

        "main: start".p
        val continuation = coroutine.createCoroutine(completion)
        "main: after createCoroutine".p
        continuation.resume(Unit)
        "main: after continuation resume (to start coroutine)".p
        Thread.sleep(3000)
        "main: after sleep 3000".p
    }

    suspend fun mynever1() {
        suspendCoroutine<Unit> { continuation ->
            "Got continuation: $continuation, but I will never call .resume(Unit)".p
        }
    }

    suspend fun mynever2() = suspendCoroutine<Unit> { continuation ->
        "Got continuation: $continuation, but I will never call .resume(Unit)".p
    }

    /**
     * Under the hood - error case investigation
     *
     * This example should never print "coroutine end", but it does immediately...
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.J_underTheHood_3
     */
    @Test
    fun J_underTheHood_3() {

        val coroutine: suspend () -> Unit = {
            "coroutine start".p
            mynever1() // TO FIX IT: CHANGE "mynever1()" TO "mynever2()"
            "coroutine end - THIS LINE SHOULD NEVER BE CALLED!".p
        }

        val completion = object : Continuation<Unit> {
            override val context = EmptyCoroutineContext
            override fun resume(value: Unit) {
                "completion: completed normally".p
            }

            override fun resumeWithException(exception: Throwable) {
                "completion: exception: $exception".p
            }
        }

        "main: start".p
        val continuation = coroutine.createCoroutine(completion)
        "main: after createCoroutine".p
        continuation.resume(Unit)
        "main: after continuation resume (to start coroutine)".p
        Thread.sleep(3000)
        "main: after sleep 3000".p
    }

    /**
     * Sequence builder test
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.K_sequence
     */
    @Test
    fun K_sequence() {
        val seq: Sequence<Int> = buildSequence {
            //delay(10) // this is forbidden
            yield(2)
            yield(4)
            yield(6)
        }
        for (i in seq) "$i".p
    }

    /**
     * Create (and start) a future representing a coroutine
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.createFuture
     */
    fun <T> createFuture(block: suspend () -> T): CompletableFuture<T> {

        val future = CompletableFuture<T>()

        val completion = object : Continuation<T> {
            override val context = EmptyCoroutineContext
            override fun resume(value: T) {
                future.complete(value)
            }

            override fun resumeWithException(exception: Throwable) {
                future.completeExceptionally(exception)
            }
        }

        block.startCoroutine(completion)

        return future
    }

    /**
     * Wrap coroutine in completable future
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.L_completableFuture
     */
    @Test
    fun L_completableFuture() {

        "main: start".p

        val future: CompletableFuture<Int> = createFuture {
            "coroutine: start".p
            delay(1000)
            "coroutine: middle".p
            delay(1000)
            "coroutine: end".p
            666
        }

        "main: before: thenAccept".p

        future
                .thenApply { it * 10 }
                .thenAccept { "thenAccept: $it".p }

        "main: after: thenAccept".p

        Thread.sleep(3000)

        "main: after: sleep".p

    }

    /**
     * Prepare a future representing a coroutine
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.prepareFuture
     */
    fun <T> prepareFuture(block: suspend () -> T): () -> CompletableFuture<T> {

        val future = CompletableFuture<T>()

        val completion = object : Continuation<T> {
            override val context = EmptyCoroutineContext
            override fun resume(value: T) {
                future.complete(value)
            }

            override fun resumeWithException(exception: Throwable) {
                future.completeExceptionally(exception)
            }
        }

        val continuation = block.createCoroutine(completion)

        return {
            continuation.resume(Unit)
            future
        }
    }

    /**
     * Wrap coroutine in LAZY completable future
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.L_completableFuture_2
     */
    @Test
    fun L_completableFuture_2() {

        "main: start".p

        val futureCreator: () -> CompletableFuture<Int> = prepareFuture {
            "coroutine: start".p
            delay(1000)
            "coroutine: middle".p
            delay(1000)
            "coroutine: end".p
            666
        }

        "main: after prepareFuture".p

        val future = futureCreator()

        "main: before: thenAccept".p

        future
                .thenApply { it * 10 }
                .thenAccept { "thenAccept: $it".p }

        "main: after: thenAccept".p

        Thread.sleep(3000)

        "main: after: sleep".p

    }

    /**
     * Wrap future in suspension point
     */
    suspend fun <T> CompletableFuture<T>.suspend(): T = suspendCoroutine { continuation ->
        thenAccept { continuation.resume(it) }
    }

    /**
     * Wrap futures in suspension points
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.L_completableFuture_3
     */
    @Test
    fun L_completableFuture_3() {

        val scheduler = Executors.newSingleThreadScheduledExecutor()

        val myDelayFuture: (time: Long) -> CompletableFuture<Unit> = { time ->
            val future = CompletableFuture<Unit>()
            scheduler.schedule({ future.complete(Unit) }, time, TimeUnit.MILLISECONDS)
            future
        }

        "main: start".p

        launch(CommonPool) {
            "coroutine start".p
            myDelayFuture(1000).suspend()
            "coroutine middle".p
            myDelayFuture(1000).suspend()
            "coroutine end".p
        }

        Thread.sleep(3000)

        "main: after: sleep".p
    }

    /**
     * Use future related functions from kotlinx.coroutines
     *
     * Important: both futures are started immediately
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.L_completableFuture_4
     */
    @Test
    fun L_completableFuture_4() {
        "main: start".p
        future {
            "main future: start".p
            val f1 = future {
                "f1: start".p
                delay(1000) // sleep 1s
                "f1: end".p
                1
            }
            val f2 = future {
                "f2: start".p
                delay(1000) // sleep 1s
                "f2: end".p
                2
            }
            "main future: before awaits".p
            val f1val = f1.await()
            "main future: after f1.await(): f1val = $f1val".p
            val f2val = f2.await()
            "main future: after f2.await(): f2val = $f2val".p
            val sum = f1val + f2val
            "main future: after awaits: sum = $sum".p
        }
        Thread.sleep(3000)
        "main: end".p
    }

    /**
     * Use prepareFuture to make last example more lazy and simple
     *
     * Now we pause two times when waiting for f1 and then for f2
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.L_completableFuture_5
     */
    @Test
    fun L_completableFuture_5() {
        "main: start".p
        future {
            "main future: start".p
            val f1 = prepareFuture {
                "f1: start".p
                delay(1000) // sleep 1s
                "f1: end".p
                1
            }
            val f2 = prepareFuture {
                "f2: start".p
                delay(1000) // sleep 1s
                "f2: end".p
                2
            }
            "main future: before awaits".p
            val f1val = f1().await()
            "main future: after f1.await(): f1val = $f1val".p
            val f2val = f2().await()
            "main future: after f2.await(): f2val = $f2val".p
            val sum = f1val + f2val
            "main future: after awaits: sum = $sum".p
        }
        Thread.sleep(3000)
        "main: end".p
    }

    interface Receiver<T> : AutoCloseable {
        suspend fun receive() : T
    }

    class RxSubscriber<T>(val block: suspend Receiver<T>.() -> Unit) : Subscriber<T> {

        private lateinit var subscription: Subscription

        private lateinit var continuation: Continuation<T>

        private val receiver = object : Receiver<T> {
            suspend override fun receive(): T = suspendCoroutine {
                continuation = it
                subscription.request(1)
            }
            override fun close() = subscription.cancel()
        }

        private val completion = object : Continuation<Unit> {
            override val context = EmptyCoroutineContext
            override fun resume(value: Unit) { subscription.cancel() }
            override fun resumeWithException(exception: Throwable) { subscription.cancel() }
        }

        override fun onSubscribe(subscription: Subscription) {
            this.subscription = subscription
            block.startCoroutine(receiver, completion)
        }

        override fun onNext(t: T) = continuation.resume(t)
        override fun onError(t: Throwable) = continuation.resumeWithException(t)
        override fun onComplete() = Unit
    }

    @Test
    fun M_rxSubscriber() {

        val flowable = Flowable
                .interval(300, TimeUnit.MILLISECONDS)
                .take(10)

        val subscriber = RxSubscriber<Long> {
            receive().p
//            close()
            receive().p
            receive().p
//            delay(1500)
            receive().p
            receive().p
            receive().p
        }

        flowable.subscribe(subscriber)

        Thread.sleep(10000)
    }
}
