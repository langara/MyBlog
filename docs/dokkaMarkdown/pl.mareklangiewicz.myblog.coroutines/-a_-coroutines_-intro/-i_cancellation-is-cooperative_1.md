[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [I_cancellationIsCooperative_1](.)

# I_cancellationIsCooperative_1

`fun I_cancellationIsCooperative_1(): Unit`

Cancellation is cooperative 1

This example shows that we can not cancel coroutine that doesn't listen

``` kotlin
sample {
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
```

