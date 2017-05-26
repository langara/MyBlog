---
title: A_Coroutines_Intro.L_completableFuture_3 - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">L_completableFuture_3</a></div>

# L_completableFuture_3

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">L_completableFuture_3</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Wrap futures in suspension points

``` kotlin
val scheduler = Executors.newSingleThreadScheduledExecutor()
val myDelayFuture: (time: Long) -> CompletableFuture<Unit> = { time ->
    val future = CompletableFuture<Unit>()
    scheduler.schedule({ future.complete(Unit) }, time, TimeUnit.MILLISECONDS)
    future
}
"main: start".p
launch(CommonPool) {
    "coroutine start".p
    myDelayFuture(1000).suspend()
    "coroutine middle".p
    myDelayFuture(1000).suspend()
    "coroutine end".p
}
Thread.sleep(3000)
"main: after: sleep".p
```

