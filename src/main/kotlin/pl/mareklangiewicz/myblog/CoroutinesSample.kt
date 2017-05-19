package pl.mareklangiewicz.myblog

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.junit.Test

/**
 * This is my attempt to learn about kotlin coroutines and write some tests on the way.
 */
class CoroutinesSample {

    /**
     * # H1
     * something under H1
     * ## H2
     * something under H2
     * ### H3
     * something under H3
     *
     * And some list:
     * - fjdksl
     * - fjdskl fdks
     * - fj sfkd fsjl
     * And now the sample itself:
     * @sample pl.mareklangiewicz.myblog.CoroutinesSample.bla
     */
    @Test
    fun bla() {
        println("bla")
        println("bla bla")
        println("bla bla bla")
    }

    /**
     * ## Lets try something simple
     * @sample pl.mareklangiewicz.myblog.CoroutinesSample.coroutinesBasics
     */
    @Test
    fun coroutinesBasics() {
        launch(CommonPool) {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        Thread.sleep(2000L)

    }

}