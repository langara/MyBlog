---
title: A_Coroutines_Intro.H_cancelJobCorrectly - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [H_cancelJobCorrectly](.)

# H_cancelJobCorrectly

`fun H_cancelJobCorrectly(): Unit`

Cancel coroutine with Job.cancel

``` kotlin
sample {
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
```

