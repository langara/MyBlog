---
title: A_Coroutines_Intro.J_underTheHood_3 - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">J_underTheHood_3</a></div>

# J_underTheHood_3

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">J_underTheHood_3</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

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

