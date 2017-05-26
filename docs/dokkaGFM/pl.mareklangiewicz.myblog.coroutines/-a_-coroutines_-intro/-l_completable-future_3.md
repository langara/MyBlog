[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [L_completableFuture_3](.)

# L_completableFuture_3

`fun L_completableFuture_3(): Unit`

Wrap futures in suspension points

``` kotlin
val scheduler = Executors.newSingleThreadScheduledExecutor()
val myDelayFuture: (time: Long) -> CompletableFuture<Unit> = { time ->
    val future = CompletableFuture<Unit>()
    scheduler.schedule({ future.complete(Unit) }, time, TimeUnit.MILLISECONDS)
    future
}
"main: start".p
launch(CommonPool) {
    "coroutine start".p
    myDelayFuture(1000).suspend()
    "coroutine middle".p
    myDelayFuture(1000).suspend()
    "coroutine end".p
}
Thread.sleep(3000)
"main: after: sleep".p
```

