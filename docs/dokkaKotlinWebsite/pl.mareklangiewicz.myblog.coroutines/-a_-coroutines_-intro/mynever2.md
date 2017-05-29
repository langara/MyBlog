---
title: A_Coroutines_Intro.mynever2 - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">mynever2</a></div>

# mynever2

<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">mynever2</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Correctly suspends forever

``` kotlin
suspendCoroutine<Unit> { continuation ->
        "Got continuation: $continuation, but I will never call .resume(Unit)".p
    }
```

