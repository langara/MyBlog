package pl.mareklangiewicz.myblog.coroutines

import io.reactivex.Flowable
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.*
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
import kotlin.system.measureTimeMillis

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
    val Any.p get() = println("Coroutines Intro [${Thread.currentThread().name.padEnd(40).substring(0, 40)}] [${getCurrentTimeString()}] $this")

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
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.E_extractSuspendingFunction
     */
    @Test fun E_extractSuspendingFunction() = sample {
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
     * Delay and return 7 with logging
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.delayAndReturn7
     */
    suspend fun delayAndReturn7(): Int {
        "delayAndReturn7: start".p
        delay(1000L)
        "delayAndReturn7: end".p
        return 7
    }

    /**
     * Delay and return 8 with logging
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.delayAndReturn8
     */
    suspend fun delayAndReturn8(): Int {
        "delayAndReturn8: start".p
        delay(1000L)
        "delayAndReturn8: end".p
        return 8
    }

    /**
     * Suspending functions are called sequentially
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.E_coroutineIsSequential
     */
    @Test fun E_coroutineIsSequential() = sample {
        "start".p
        val result = delayAndReturn7() + delayAndReturn8()
        "end result: $result.".p // it will take two seconds to print it
    }

    /**
     * Run suspending functions in parallel
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.E_coroutineParallel
     */
    @Test fun E_coroutineParallel() = sample {
        "start".p
        val a1 = async(context) { delayAndReturn7() } // we do NOT await for it yet (but it already starts the `delayAndReturn7`)
        val a2 = async(context) { delayAndReturn8() } // we do NOT await for it yet (but it already starts the `delayAndReturn8`)
        val result = a1.await() + a2.await()
        "end result: $result.".p // it will take ONE second to print it
    }

    /**
     * Run suspending functions in parallel, but lazily
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.E_lazyAsync
     */
    @Test fun E_lazyAsync() = sample {
        "start".p
        val a1 = async(context, CoroutineStart.LAZY) { delayAndReturn7() }
        val a2 = async(context, CoroutineStart.LAZY) { delayAndReturn8() }
        val result = a1.await() + a2.await()
        "end result: $result.".p // it will take TWO second to print it
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
     * Cancellation with timeout
     *
     * This example shows `withTimeout` function
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.I_cancellationIsCooperative_3_withTimeout
     */
    @Test fun I_cancellationIsCooperative_3_withTimeout() = sample {
        "main: start.".p
        launch(CommonPool) {
            withTimeout(100) {
                // change to 10000 to see the difference
                var nextPrintTime = 0L
                while (true) { // computation loop
                    yield() // this will throw CancellationException on timeout
                    val currentTime = System.currentTimeMillis()
                    if (currentTime >= nextPrintTime) {
                        "I'm sleeping...".p
                        nextPrintTime = currentTime + 500L
                    }
                }
            }
        }
        delay(3000L) // delay a bit
        "main: end.".p
    }

    /**
     * Different contexts example
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.IA_contexts
     */
    @Test fun IA_contexts() = sample {

        "main: start".p

        val jobs = arrayListOf<Job>()

        jobs += launch(Unconfined) {
            // not confined -- will work with main thread
            "Unconfined".p
        }
        jobs += launch(context) {
            // context of the parent, runBlocking coroutine
            "context".p
        }
        jobs += launch(CommonPool) {
            // will get dispatched to ForkJoinPool.commonPool (or equivalent)
            "CommonPool".p
        }
        jobs += launch(newSingleThreadContext("MyOwnThread")) {
            // will get its own new thread
            "newSTC".p
        }

        "main: joining all jobs".p

        for (job in jobs)
            job.join()

        "main: end".p
    }

    /**
     * run and runBlocking with specified context
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.IA_contexts_2
     */
    @Test fun IA_contexts_2() {
        "main: start".p
        val ctx1 = newSingleThreadContext("Ctx1")
        val ctx2 = newSingleThreadContext("Ctx2")
        runBlocking(ctx1) {
            "runBlocking(ctx1): start".p
            run(ctx2) {
                "run(ctx2)".p
            }
            "runBlocking(ctx1): end".p
        }
        "main: end".p
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

    private val myscheduler = Executors.newSingleThreadScheduledExecutor()

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

    /**
     * Should suspend forever (but it does not)
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.mynever1
     */
    suspend fun mynever1() {
        suspendCoroutine<Unit> { continuation ->
            "Got continuation: $continuation, but I will never call .resume(Unit)".p
        }
    }

    /**
     * Correctly suspends forever
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.mynever2
     */
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
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.suspend
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

    /**
     * Something that you can ask for items, but it can suspend when item is not available yet
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.Receiver
     */
    interface Receiver<T> : AutoCloseable {

        /**
         * Receives next item immediately or suspends if no item is ready
         */
        suspend fun receive(): T
    }

    /**
     * Wraps a coroutine block in rx subscriber class.
     *
     * Returned subscriber can be used in [Flowable.subscribe]
     * It honors back pressure correctly
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.RxSubscriber
     */
    class RxSubscriber<T>(private val block: suspend Receiver<T>.() -> Unit) : Subscriber<T> {

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
            override fun resume(value: Unit) {
                subscription.cancel()
            }

            override fun resumeWithException(exception: Throwable) {
                subscription.cancel()
            }
        }

        /**
         * Starts the coroutine
         */
        override fun onSubscribe(subscription: Subscription) {
            this.subscription = subscription
            block.startCoroutine(receiver, completion)
        }

        /**
         * Resumes the coroutine with given item
         */
        override fun onNext(t: T) = continuation.resume(t)

        /**
         * Resumes the coroutine with given exception
         */
        override fun onError(t: Throwable) = continuation.resumeWithException(t)

        /**
         * Does nothing
         */
        override fun onComplete() = Unit
    }

    /**
     * Implement rx subscriber wrapping coroutine block
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.M_rxSubscriber
     */
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

    /**
     * Fibonacci numbers generator
     *
     * Sends given number of Fibonacci numbers to given [SendChannel]
     */
    suspend fun fibonacci(n: Int, c: SendChannel<Int>) {
        var x = 0
        var y = 1
        for (i in 0..n - 1) {
//            delay(400)
            "sending $x".p
            c.send(x)
            "sending $x done.".p

            val next = x + y
            x = y
            y = next
        }
        c.close()
    }

    /**
     * Use channels to implement fibonacci numbers generator
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.N_fibonacciChannels
     */
    @Test
    fun N_fibonacciChannels() {
        val c = Channel<Int>(2) // experiment with different capacity
        launch(CommonPool) {
            fibonacci(10, c)
        }
        launch(CommonPool) {
            for (x in c) {
                delay(300)
                "*********************** received $x".p
            }
        }
        Thread.sleep(3000)
    }

    /**
     * Use `produce` utility function
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.O_produceChannel
     */
    @Test
    fun O_produceChannel() {

        "main: start".p

        val channel = produce(CommonPool) {
            for (i in 1..10) {
                "produce: sending: $i".p
                send(i)
            }
        }

        launch(CommonPool) {
            for (i in channel)
                "received: $i".p
        }

        Thread.sleep(2000)

        "main: end".p

    }

    /**
     * Produces successive numbers
     */
    fun produceNumbersFrom(context: CoroutineContext, from: Int) = produce(context) {
        var x = from
        while (true) {
            send(x++)
            delay(50)
        }
    }

    /**
     * Simple filter implementation for channels
     */
    fun <T> ReceiveChannel<T>.filter(context: CoroutineContext, predicate: suspend (T) -> Boolean) = produce(context) {
        for (t in this@filter)
            if (predicate(t))
                send(t)
    }

    /**
     * Generate prime numbers with crazy channels pipeline
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.P_producePrimeNumbers
     */
    @Test
    fun P_producePrimeNumbers() = sample {
        var cur = produceNumbersFrom(CommonPool, 2)
        for (i in 1..20) {
            val prime = cur.receive()
            "prime: $prime".p
            cur = cur.filter(context) { it % prime != 0 }
        }
    }

    /**
     * Take specified number of items from channel and send it further
     */
    fun <T> ReceiveChannel<T>.take(context: CoroutineContext, size: Long) = produce(context) {
        for (i in 1..size)
            send(receive())
    }

    /**
     * Sends given value indefinitely
     */
    suspend fun <T> SendChannel<T>.sendPeriodically(t: T, delay: Long) {
        while (true) {
            delay(delay)
            send(t)
        }
    }

    /**
     * One receiver, two senders
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.Q_oneReceiverTwoSenders
     */
    @Test
    fun Q_oneReceiverTwoSenders() = sample {

        val channel = Channel<String>()

        launch(context) { channel.sendPeriodically("foo200", 200) }
        launch(context) { channel.sendPeriodically("BAR500", 500) }

        for (s in channel.take(context, 6))
            s.p
    }

    /**
     * Prints all received values from given channel with "processor #id" prefix
     */
    fun <T> ReceiveChannel<T>.processAll(id: Int) = launch(CommonPool) {
        for (t in this@processAll)
            "processor #$id: $t".p
    }

    /**
     * One sender, five receivers
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.Q_oneSenderFiveReceivers
     */
    @Test
    fun Q_oneSenderFiveReceivers() = sample {
        val sender = produceNumbersFrom(CommonPool, 1)
        for (i in 1..5)
            sender.processAll(i)
        delay(500)
//        sender.cancel()
        delay(500)
    }


    /**
     * A ball in ping pong game
     *
     * @property hits How many times it was hit
     */
    data class Ball(var hits: Int)


    /**
     * A player in ping pong game
     */
    suspend fun player(name: String, table: Channel<Ball>) {
        for (ball in table) { // receive the ball in a loop
            ball.hits++
            "$name $ball".p
            delay(300) // wait a bit
            table.send(ball) // send the ball back
        }
    }

    /**
     * Channels are fair
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.R_channelsAreFair
     */
    @Test
    fun R_channelsAreFair() = sample {
        val table = Channel<Ball>() // a shared table
        launch(context) { player("ping", table) }
        launch(context) { player("pong", table) }
//        launch(context) { player("PENGGG", table) }
        table.send(Ball(0)) // serve the ball
        delay(2000) // delay 1 second
        table.receive() // game over, grab the ball
    }

    /**
     * Runs given action a million times using thousand coroutines
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.massiveRun
     */
    suspend fun massiveRun(context: CoroutineContext, action: suspend () -> Unit) {
        val n = 1000 // number of coroutines to launch
        val k = 1000 // times an action is repeated by each coroutine
        val time = measureTimeMillis {
            val jobs = List(n) {
                launch(context) {
                    repeat(k) { action() }
                }
            }
            jobs.forEach { it.join() }
        }
    }

    /**
     * Massive non sync action
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.R_massiveNonsyncAction
     */
    @Test
    fun R_massiveNonsyncAction() = sample {

        "start".p

        var counter = 0 // @Volatile would not help much; AtomicInteger would work correctly.

//        val context = newSingleThreadContext("single") // this will increment counter correctly all the times
        val context = newFixedThreadPoolContext(2, "double") // this should cause some sync errors
//        val context = CommonPool // this should cause some sync errors on systems with multiple CPUs (more than 2)

        massiveRun(context) {
            counter ++
        }

        "end. counter: $counter (should be 1000000) (error: ${1000000-counter})".p
    }
}

