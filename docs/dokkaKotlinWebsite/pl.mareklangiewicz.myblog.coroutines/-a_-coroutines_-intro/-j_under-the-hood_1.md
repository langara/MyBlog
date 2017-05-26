---
title: A_Coroutines_Intro.J_underTheHood_1 - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">J_underTheHood_1</a></div>

# J_underTheHood_1

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">J_underTheHood_1</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Under the hood test

``` kotlin
val coroutine: suspend Unit.() -> Unit = {
    "coroutine start".p
    delay(1000)
    "coroutine middle".p
    delay(1000)
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
coroutine.startCoroutine(Unit, completion)
"main: after startCoroutine".p
Thread.sleep(3000)
"main: after sleep 3000".p
```

