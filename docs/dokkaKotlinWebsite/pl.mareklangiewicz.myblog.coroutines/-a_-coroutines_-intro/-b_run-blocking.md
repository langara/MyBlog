---
title: A_Coroutines_Intro.B_runBlocking - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">B_runBlocking</a></div>

# B_runBlocking

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">B_runBlocking</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

``` kotlin
runBlocking {
    delay(1000)
    println("1000")
    delay(1000)
    println("2000")
    delay(1000)
    println("3000")
}
```

