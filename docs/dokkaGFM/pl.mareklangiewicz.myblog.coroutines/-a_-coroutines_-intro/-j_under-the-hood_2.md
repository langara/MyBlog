[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [J_underTheHood_2](.)

# J_underTheHood_2

`fun J_underTheHood_2(): Unit`

Under the hood test 2 without using kotlinx stuff
FIXME NOW: this doesn't work correctly (it logs too much)!

``` kotlin
val scheduler = Executors.newSingleThreadScheduledExecutor()
val mydelay: suspend (time: Long) -> Unit = { time ->
    suspendCoroutine<Unit> { continuation ->
        scheduler.schedule({ continuation.resume(Unit) }, time, TimeUnit.MILLISECONDS)
    }
}
val coroutine: suspend () -> Unit = {
    "coroutine start".p
    mydelay(1000)
    "coroutine middle".p
    mydelay(1000)
    "coroutine end".p
}
val completion = object : Continuation<Unit> {
    override val context = EmptyCoroutineContext
    override fun resume(value: Unit) {
        "completion: completed normally".p
    }
    override fun resumeWithException(exception: Throwable) {
        "completion: exception: $exception".p
    }
}
"main: start".p
val continuation = coroutine.createCoroutine(completion)
"main: after createCoroutine".p
continuation.resume(Unit)
"main: after continuation resume (to start coroutine)".p
Thread.sleep(3000)
"main: after sleep 3000".p
```

