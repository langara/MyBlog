---
title: A_Coroutines_Intro.L_completableFuture - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">L_completableFuture</a></div>

# L_completableFuture

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">L_completableFuture</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Wrap coroutine in completable future

``` kotlin
"main: start".p
val future: CompletableFuture<Int> = createFuture {
    "coroutine: start".p
    delay(1000)
    "coroutine: middle".p
    delay(1000)
    "coroutine: end".p
    666
}
"main: before: thenAccept".p
future
        .thenApply { it * 10 }
        .thenAccept { "thenAccept: $it".p }
"main: after: thenAccept".p
Thread.sleep(3000)
"main: after: sleep".p
```

