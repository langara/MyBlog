---
title: A_Coroutines_Intro.A_basics - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">A_basics</a></div>

# A_basics

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">A_basics</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

First coroutine

``` kotlin
launch(CommonPool) {
    delay(1000L)
    println("World!")
}
println("Hello,")
Thread.sleep(2000L)
```

