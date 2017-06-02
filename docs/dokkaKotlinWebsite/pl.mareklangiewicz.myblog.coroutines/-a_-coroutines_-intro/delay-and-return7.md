---
title: A_Coroutines_Intro.delayAndReturn7 - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">delayAndReturn7</a></div>

# delayAndReturn7

<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">delayAndReturn7</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Int</span></code></div>

Delay and return 7 with logging

``` kotlin
"delayAndReturn7: start".p
delay(1000L)
"delayAndReturn7: end".p
return 7
```

