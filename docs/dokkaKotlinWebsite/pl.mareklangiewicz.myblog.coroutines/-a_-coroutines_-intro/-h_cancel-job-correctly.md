---
title: A_Coroutines_Intro.H_cancelJobCorrectly - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">H_cancelJobCorrectly</a></div>

# H_cancelJobCorrectly

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">H_cancelJobCorrectly</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

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

