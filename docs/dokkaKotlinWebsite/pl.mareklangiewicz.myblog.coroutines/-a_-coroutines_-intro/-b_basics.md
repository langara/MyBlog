---
title: A_Coroutines_Intro.B_basics - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">B_basics</a></div>

# B_basics

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">B_basics</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

some B_basics

## Lets try something simple

``` kotlin
launch(CommonPool) {
    delay(1000L)
    println("World!")
}
println("Hello,")
Thread.sleep(2000L)
```

