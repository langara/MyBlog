---
title: A_Coroutines_Intro.prepareFuture - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">prepareFuture</a></div>

# prepareFuture

<div class="signature"><code><span class="keyword">fun </span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span> <span class="identifier">prepareFuture</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$prepareFuture(kotlin.coroutines.SuspendFunction0((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.prepareFuture.T)))/block">block</span><span class="symbol">:</span>&nbsp;<span class="identifier">SuspendFunction0</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span><br/><span class="symbol">)</span><span class="symbol">: </span><span class="symbol">(</span><span class="symbol">)</span>&nbsp;<span class="symbol">-&gt;</span>&nbsp;<a href="http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html"><span class="identifier">CompletableFuture</span></a><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span></code></div>

Prepare a future representing a coroutine

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
val continuation = block.createCoroutine(completion)
return {
    continuation.resume(Unit)
    future
}
```

