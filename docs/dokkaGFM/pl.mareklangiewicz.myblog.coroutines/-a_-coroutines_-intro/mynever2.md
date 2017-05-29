[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [mynever2](.)

# mynever2

`suspend fun mynever2(): Unit`

Correctly suspends forever

``` kotlin
suspendCoroutine<Unit> { continuation ->
        "Got continuation: $continuation, but I will never call .resume(Unit)".p
    }
```

