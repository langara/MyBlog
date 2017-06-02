---
title: A_Coroutines_Intro.E_coroutineIsSequential - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">E_coroutineIsSequential</a></div>

# E_coroutineIsSequential

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">E_coroutineIsSequential</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Suspending functions are called sequentially

``` kotlin
sample {
        "start".p
        val result = delayAndReturn7() + delayAndReturn8()
        "end result: $result.".p // it will take two seconds to print it
    }
```

