---
title: A_Coroutines_Intro.mynever1 - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">mynever1</a></div>

# mynever1

<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">mynever1</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Should suspend forever (but it does not)

``` kotlin
suspendCoroutine<Unit> { continuation ->
    "Got continuation: $continuation, but I will never call .resume(Unit)".p
}
```

