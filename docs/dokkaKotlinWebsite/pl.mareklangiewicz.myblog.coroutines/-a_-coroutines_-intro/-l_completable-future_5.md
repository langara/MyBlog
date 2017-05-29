---
title: A_Coroutines_Intro.L_completableFuture_5 - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">L_completableFuture_5</a></div>

# L_completableFuture_5

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">L_completableFuture_5</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Use prepareFuture to make last example more lazy and simple

Now we pause two times when waiting for f1 and then for f2

``` kotlin
"main: start".p
future {
    "main future: start".p
    val f1 = prepareFuture {
        "f1: start".p
        delay(1000) // sleep 1s
        "f1: end".p
        1
    }
    val f2 = prepareFuture {
        "f2: start".p
        delay(1000) // sleep 1s
        "f2: end".p
        2
    }
    "main future: before awaits".p
    val f1val = f1().await()
    "main future: after f1.await(): f1val = $f1val".p
    val f2val = f2().await()
    "main future: after f2.await(): f2val = $f2val".p
    val sum = f1val + f2val
    "main future: after awaits: sum = $sum".p
}
Thread.sleep(3000)
"main: end".p
```

