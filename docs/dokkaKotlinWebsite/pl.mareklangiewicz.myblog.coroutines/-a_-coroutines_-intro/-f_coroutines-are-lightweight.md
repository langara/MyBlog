---
title: A_Coroutines_Intro.F_coroutinesAreLightweight - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">F_coroutinesAreLightweight</a></div>

# F_coroutinesAreLightweight

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">F_coroutinesAreLightweight</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Run 100 000 coroutines in parallel

Coroutines are extremely lightweight so we can start **A LOT** of them

``` kotlin
sample {
        val jobs = List(100_000) {
            // create a lot of coroutines and list their jobs
            launch(CommonPool) {
                delay(1000L)
                print(".")
            }
        }
        jobs.forEach { it.join() } // wait for all jobs to complete    }
    }
```

