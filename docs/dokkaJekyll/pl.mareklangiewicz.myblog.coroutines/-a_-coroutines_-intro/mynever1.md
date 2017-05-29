---
title: A_Coroutines_Intro.mynever1 - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [mynever1](.)

# mynever1

`suspend fun mynever1(): Unit`

Should suspend forever (but it does not)

``` kotlin
suspendCoroutine<Unit> { continuation ->
    "Got continuation: $continuation, but I will never call .resume(Unit)".p
}
```

