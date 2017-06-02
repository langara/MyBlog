---
title: A_Coroutines_Intro.E_lazyAsync - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">E_lazyAsync</a></div>

# E_lazyAsync

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">E_lazyAsync</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Run suspending functions in parallel, but lazily

``` kotlin
sample {
        "start".p
        val a1 = async(context, CoroutineStart.LAZY) { delayAndReturn7() }
        val a2 = async(context, CoroutineStart.LAZY) { delayAndReturn8() }
        val result = a1.await() + a2.await()
        "end result: $result.".p // it will take TWO second to print it
    }
```

