---
title: A_Coroutines_Intro.IA_contexts - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">IA_contexts</a></div>

# IA_contexts

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">IA_contexts</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Different contexts example

``` kotlin
sample {
        "main: start".p
        val jobs = arrayListOf<Job>()
        jobs += launch(Unconfined) {
            // not confined -- will work with main thread
            "Unconfined".p
        }
        jobs += launch(context) {
            // context of the parent, runBlocking coroutine
            "context".p
        }
        jobs += launch(CommonPool) {
            // will get dispatched to ForkJoinPool.commonPool (or equivalent)
            "CommonPool".p
        }
        jobs += launch(newSingleThreadContext("MyOwnThread")) {
            // will get its own new thread
            "newSTC".p
        }
        "main: joining all jobs".p
        for (job in jobs)
            job.join()
        "main: end".p
    }
```

