---
title: A_Coroutines_Intro.I_cancellationIsCooperative_1 - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">I_cancellationIsCooperative_1</a></div>

# I_cancellationIsCooperative_1

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">I_cancellationIsCooperative_1</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

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

