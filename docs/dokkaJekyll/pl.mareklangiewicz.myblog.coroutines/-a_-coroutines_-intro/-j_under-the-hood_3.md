---
title: A_Coroutines_Intro.J_underTheHood_3 - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [J_underTheHood_3](.)

# J_underTheHood_3

`fun J_underTheHood_3(): Unit`

Under the hood - error case investigation

This example should never print "coroutine end", but it does immediately...

``` kotlin
val coroutine: suspend () -> Unit = {
    "coroutine start".p
    mynever1() // TO FIX IT: CHANGE "mynever1()" TO "mynever2()"
    "coroutine end - THIS LINE SHOULD NEVER BE CALLED!".p
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

