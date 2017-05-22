[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [J_underTheHood_1](.)

# J_underTheHood_1

`fun J_underTheHood_1(): Unit`

Under the hood test

``` kotlin
val coroutine: suspend Unit.() -> Unit = {
    "coroutine start".p
    delay(1000)
    "coroutine middle".p
    delay(1000)
    "coroutine end".p
}
val completition = object : Continuation<Unit> {
    override val context = EmptyCoroutineContext
    override fun resume(value: Unit) { "completition: completed normally".p }
    override fun resumeWithException(exception: Throwable) { "completition: exception: $exception".p }
}
"main: start".p
coroutine.startCoroutine(Unit, completition)
"main: after startCoroutine".p
Thread.sleep(3000)
"main: after sleep 3000".p
```

