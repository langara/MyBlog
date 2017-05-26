---
title: A_Coroutines_Intro.createFuture - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">createFuture</a></div>

# createFuture

<div class="signature"><code><span class="keyword">fun </span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span> <span class="identifier">createFuture</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$createFuture(kotlin.coroutines.SuspendFunction0((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.createFuture.T)))/block">block</span><span class="symbol">:</span>&nbsp;<span class="identifier">SuspendFunction0</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span><br/><span class="symbol">)</span><span class="symbol">: </span><a href="http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html"><span class="identifier">CompletableFuture</span></a><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span></code></div>

Create (and start) a future representing a coroutine

``` kotlin
val future = CompletableFuture<T>()
val completion = object : Continuation<T> {
    override val context = EmptyCoroutineContext
    override fun resume(value: T) {
        future.complete(value)
    }
    override fun resumeWithException(exception: Throwable) {
        future.completeExceptionally(exception)
    }
}
block.startCoroutine(completion)
return future
```

