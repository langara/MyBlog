---
title: A_Coroutines_Intro.delayAndReturn8 - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">delayAndReturn8</a></div>

# delayAndReturn8

<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">delayAndReturn8</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Int</span></code></div>

Delay and return 8 with logging

``` kotlin
"delayAndReturn8: start".p
delay(1000L)
"delayAndReturn8: end".p
return 8
```

