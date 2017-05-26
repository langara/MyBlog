---
title: A_Coroutines_Intro.L_completableFuture - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [L_completableFuture](.)

# L_completableFuture

`fun L_completableFuture(): Unit`

Wrap coroutine in completable future

``` kotlin
"main: start".p
val future: CompletableFuture<Int> = createFuture {
    "coroutine: start".p
    delay(1000)
    "coroutine: middle".p
    delay(1000)
    "coroutine: end".p
    666
}
"main: before: thenAccept".p
future
        .thenApply { it * 10 }
        .thenAccept { "thenAccept: $it".p }
"main: after: thenAccept".p
Thread.sleep(3000)
"main: after: sleep".p
```

