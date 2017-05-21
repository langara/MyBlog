---
title: A_Coroutines_Intro.D_introduceJob - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">D_introduceJob</a></div>

# D_introduceJob

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">D_introduceJob</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Use Job class to handle coroutine state and to wait (non blocking) for it to finish

``` kotlin
sample {
        val job = launch(CommonPool) {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        job.join() // this suspending function (join) waits for job to finish
    }
```

