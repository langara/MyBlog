[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [G_exitWhileCoroutineStillActive](.)

# G_exitWhileCoroutineStillActive

`fun G_exitWhileCoroutineStillActive(): Unit`

Active coroutines are terminated when the whole process ends (like daemon threads)

``` kotlin
sample {
        launch(CommonPool) {
            repeat(1000) { i ->
                "I'm sleeping $i ...".p
                delay(500L)
            }
        }
        delay(1300L) // just quit after delay
    }
```

