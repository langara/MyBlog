---
title: A_Coroutines_Intro.I_cancellationIsCooperative_3_withTimeout - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [I_cancellationIsCooperative_3_withTimeout](.)

# I_cancellationIsCooperative_3_withTimeout

`fun I_cancellationIsCooperative_3_withTimeout(): Unit`

Cancellation with timeout

This example shows `withTimeout` function

``` kotlin
sample {
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
```

