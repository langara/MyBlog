package pl.mareklangiewicz.myblog.coroutines

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.junit.Test

/**
 * Kotlin Coroutines Intro in "TDD"
 *
 * This is my attempt to learn about kotlin coroutines and write some tests on the way.
 */
class CoroutinesIntro {

    /**
     * Some "bla" function
     *
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
     * @sample pl.mareklangiewicz.myblog.coroutines.CoroutinesIntro.bla
     */
    @Test
    fun bla() {
        println("bla")
        println("bla bla")
        println("bla bla bla")
    }

    /**
     * some basics
     *
     * ## Lets try something simple
     * @sample pl.mareklangiewicz.myblog.coroutines.CoroutinesIntro.basics
     */
    @Test
    fun basics() {
        launch(CommonPool) {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        Thread.sleep(2000L)

    }

}