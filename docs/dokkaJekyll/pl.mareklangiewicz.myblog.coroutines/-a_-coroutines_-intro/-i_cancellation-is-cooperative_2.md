---
title: A_Coroutines_Intro.I_cancellationIsCooperative_2 - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [I_cancellationIsCooperative_2](.)

# I_cancellationIsCooperative_2

`fun I_cancellationIsCooperative_2(): Unit`

Cancellation is cooperative 2

This example shows that we can cancel coroutine using isActive property from [CoroutineScope](#)

``` kotlin
sample {
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
```

