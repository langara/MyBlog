---
title: A_Coroutines_Intro.createFuture - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [createFuture](.)

# createFuture

`fun <T> createFuture(block: SuspendFunction0<T>): `[`CompletableFuture`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html)`<T>`

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

