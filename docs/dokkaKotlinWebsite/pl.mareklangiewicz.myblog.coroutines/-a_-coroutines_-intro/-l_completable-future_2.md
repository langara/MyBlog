---
title: A_Coroutines_Intro.L_completableFuture_2 - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">L_completableFuture_2</a></div>

# L_completableFuture_2

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">L_completableFuture_2</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Wrap coroutine in LAZY completable future

``` kotlin
"main: start".p
val futureCreator: () -> CompletableFuture<Int> = prepareFuture {
    "coroutine: start".p
    delay(1000)
    "coroutine: middle".p
    delay(1000)
    "coroutine: end".p
    666
}
"main: after prepareFuture".p
val future = futureCreator()
"main: before: thenAccept".p
future
        .thenApply { it * 10 }
        .thenAccept { "thenAccept: $it".p }
"main: after: thenAccept".p
Thread.sleep(3000)
"main: after: sleep".p
```

