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
class A_Coroutines_Intro {

    /**
     * Some "A_bla" function
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
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.A_bla
     */
    @Test
    fun A_bla() {
        println("A_bla")
        println("A_bla A_bla")
        println("A_bla A_bla A_bla")
    }

    /**
     * some B_basics
     *
     * ## Lets try something simple
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.B_basics
     */
    @Test
    fun B_basics() {
        launch(CommonPool) {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        Thread.sleep(2000L)

    }

}