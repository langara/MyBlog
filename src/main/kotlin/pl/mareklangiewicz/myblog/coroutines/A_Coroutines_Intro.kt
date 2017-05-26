package pl.mareklangiewicz.myblog.coroutines

import kotlinx.coroutines.experimental.*
import org.junit.Ignore
import org.junit.Test
import java.util.*
import kotlinx.coroutines.experimental.CoroutineScope
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import kotlin.coroutines.experimental.*
import kotlin.test.fail

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
    val String.p get() = println("Coroutines Intro [${getCurrentTimeString()}] $this")

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
     * FIXME: this throws an exception and I don't know why...
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


    /**
     * Under the hood test 2 without using kotlinx stuff
     * FIXME NOW: this doesn't work correctly (it logs too much)!
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.J_underTheHood_2
     */
    @Test
    fun J_underTheHood_2() {

        val scheduler = Executors.newSingleThreadScheduledExecutor()

        val mydelay: suspend (time: Long) -> Unit = { time ->
            suspendCoroutine<Unit> { continuation ->
                scheduler.schedule({ continuation.resume(Unit) }, time, TimeUnit.MILLISECONDS)
            }
        }

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
     * Under the hood - error case investigation
     * FIXME NOW: this example should never print "coroutine end", but it does immediately!
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.J_underTheHood_3
     */
    @Test
    fun J_underTheHood_3() {

        val mynever: suspend () -> Unit = {
            suspendCoroutine<Unit> { continuation ->
                "Got continuation: $continuation, but I will never call .resume(Unit)".p
            }
        }

        val coroutine: suspend () -> Unit = {
            "coroutine start".p
            mynever()
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
    fun <T> createFuture(block: suspend () -> T) : CompletableFuture<T> {

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
    fun <T> prepareFuture(block: suspend () -> T) : () -> CompletableFuture<T> {

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
}