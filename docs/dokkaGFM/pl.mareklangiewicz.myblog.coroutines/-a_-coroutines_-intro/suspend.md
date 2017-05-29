[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [suspend](.)

# suspend

`suspend fun <T> `[`CompletableFuture`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html)`<T>.suspend(): T`

Wrap future in suspension point

``` kotlin
suspendCoroutine { continuation ->
        thenAccept { continuation.resume(it) }
    }
```

