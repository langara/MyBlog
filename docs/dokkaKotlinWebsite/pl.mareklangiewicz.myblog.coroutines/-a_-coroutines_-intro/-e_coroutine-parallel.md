---
title: A_Coroutines_Intro.E_coroutineParallel - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">E_coroutineParallel</a></div>

# E_coroutineParallel

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">E_coroutineParallel</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Run suspending functions in parallel

``` kotlin
sample {
        "start".p
        val a1 = async(context) { delayAndReturn7() } // we do NOT await for it yet (but it already starts the `delayAndReturn7`)
        val a2 = async(context) { delayAndReturn8() } // we do NOT await for it yet (but it already starts the `delayAndReturn8`)
        val result = a1.await() + a2.await()
        "end result: $result.".p // it will take ONE second to print it
    }
```

