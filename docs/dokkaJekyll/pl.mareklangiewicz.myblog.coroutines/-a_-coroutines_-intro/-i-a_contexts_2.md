---
title: A_Coroutines_Intro.IA_contexts_2 - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [IA_contexts_2](.)

# IA_contexts_2

`fun IA_contexts_2(): Unit`

run and runBlocking with specified context

``` kotlin
"main: start".p
val ctx1 = newSingleThreadContext("Ctx1")
val ctx2 = newSingleThreadContext("Ctx2")
runBlocking(ctx1) {
    "runBlocking(ctx1): start".p
    run(ctx2) {
        "run(ctx2)".p
    }
    "runBlocking(ctx1): end".p
}
"main: end".p
```

