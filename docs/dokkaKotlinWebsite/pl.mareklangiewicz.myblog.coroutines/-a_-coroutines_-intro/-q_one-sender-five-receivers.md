---
title: A_Coroutines_Intro.Q_oneSenderFiveReceivers - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">Q_oneSenderFiveReceivers</a></div>

# Q_oneSenderFiveReceivers

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">Q_oneSenderFiveReceivers</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

One sender, five receivers

``` kotlin
sample {
        val sender = produceNumbersFrom(CommonPool, 1)
        for (i in 1..5)
            sender.processAll(i)
        delay(500)
//        sender.cancel()
        delay(500)
    }
```

