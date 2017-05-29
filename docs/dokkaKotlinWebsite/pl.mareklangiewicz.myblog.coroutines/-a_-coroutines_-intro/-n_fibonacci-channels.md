---
title: A_Coroutines_Intro.N_fibonacciChannels - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">N_fibonacciChannels</a></div>

# N_fibonacciChannels

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">N_fibonacciChannels</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Use channels to implement fibonacci numbers generator

``` kotlin
val c = Channel<Int>(2) // experiment with different capacity
launch(CommonPool) {
    fibonacci(10, c)
}
launch(CommonPool) {
    for (x in c) {
        delay(300)
        "*********************** received $x".p
    }
}
Thread.sleep(3000)
```

