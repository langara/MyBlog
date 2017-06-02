---
title: A_Coroutines_Intro.O_produceChannel - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">O_produceChannel</a></div>

# O_produceChannel

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">O_produceChannel</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Use <code>produce</code> utility function

``` kotlin
"main: start".p
val channel = produce(CommonPool) {
    for (i in 1..10) {
        "produce: sending: $i".p
        send(i)
    }
}
launch(CommonPool) {
    for (i in channel)
        "received: $i".p
}
Thread.sleep(2000)
"main: end".p
```

