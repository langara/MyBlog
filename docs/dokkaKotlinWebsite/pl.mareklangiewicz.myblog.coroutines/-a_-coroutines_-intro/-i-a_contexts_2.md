---
title: A_Coroutines_Intro.IA_contexts_2 - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">IA_contexts_2</a></div>

# IA_contexts_2

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">IA_contexts_2</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

run and runBlocking with specified context

``` kotlin
"main: start".p
val ctx1 = newSingleThreadContext("Ctx1")
val ctx2 = newSingleThreadContext("Ctx2")
runBlocking(ctx1) {
    "runBlocking(ctx1): start".p
    run(ctx2) {
        "run(ctx2)".p
    }
    "runBlocking(ctx1): end".p
}
"main: end".p
```

