---
title: A_Coroutines_Intro.L_completableFuture_2 - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [L_completableFuture_2](.)

# L_completableFuture_2

`fun L_completableFuture_2(): Unit`

Wrap coroutine in LAZY completable future

``` kotlin
"main: start".p
val futureCreator: () -> CompletableFuture<Int> = prepareFuture {
    "coroutine: start".p
    delay(1000)
    "coroutine: middle".p
    delay(1000)
    "coroutine: end".p
    666
}
"main: after prepareFuture".p
val future = futureCreator()
"main: before: thenAccept".p
future
        .thenApply { it * 10 }
        .thenAccept { "thenAccept: $it".p }
"main: after: thenAccept".p
Thread.sleep(3000)
"main: after: sleep".p
```

