---
title: CoroutinesIntro.basics - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">CoroutinesIntro</a> / <a href=".">basics</a></div>

# basics

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">basics</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

some basics

## Lets try something simple

``` kotlin
launch(CommonPool) {
    delay(1000L)
    println("World!")
}
println("Hello,")
Thread.sleep(2000L)
```

