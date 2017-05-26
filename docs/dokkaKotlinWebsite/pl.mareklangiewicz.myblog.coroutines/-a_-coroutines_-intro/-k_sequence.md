---
title: A_Coroutines_Intro.K_sequence - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">K_sequence</a></div>

# K_sequence

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">K_sequence</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Sequence builder test

``` kotlin
val seq: Sequence<Int> = buildSequence {
    //delay(10) // this is forbidden
    yield(2)
    yield(4)
    yield(6)
}
for (i in seq) "$i".p
```

