---
title: A_Coroutines_Intro.I_cancellationIsCooperative_2 - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">I_cancellationIsCooperative_2</a></div>

# I_cancellationIsCooperative_2

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">I_cancellationIsCooperative_2</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Cancellation is cooperative 2

This example shows that we can cancel coroutine using isActive property from <a href="#">CoroutineScope</a>

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

