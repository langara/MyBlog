package pl.mareklangiewicz.myblog.coroutines

import kotlinx.coroutines.experimental.*
import org.junit.Test

/**
 * Kotlin Coroutines Intro in "TDD" (kind of..)
 *
 * This is my attempt to learn about kotlin coroutines and write some tests on the way.
 *
 * The content here is based on [Coroutines Guide](https://github.com/Kotlin/kotlinx.coroutines/blob/master/coroutines-guide.md)
 * but here it is both: documentation, and executable code in one place.
 */
class A_Coroutines_Intro {

    /**
     * First coroutine
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.A_basics
     */
    @Test
    fun A_basics() {
        launch(CommonPool) {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
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
            println("1000")
            delay(1000)
            println("2000")
            delay(1000)
            println("3000")
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
        println("1000")
        delay(1000)
        println("2000")
    }

    /**
     * Use Job class to handle coroutine state and to wait (non blocking) for it to finish
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.D_introduceJob
     */
    @Test fun D_introduceJob() = sample {
        val job = launch(CommonPool) {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
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
        println("Hello,")
        job.join() // this suspending function (join) waits for job to finish

    }

    /**
     * Extracted fun delayAndPrintWorld
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.delayAndPrintWorld
     */
    suspend fun delayAndPrintWorld() {
        delay(1000L)
        println("World!")
    }


}