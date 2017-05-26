[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [prepareFuture](.)

# prepareFuture

`fun <T> prepareFuture(block: SuspendFunction0<T>): () -> `[`CompletableFuture`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html)`<T>`

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

