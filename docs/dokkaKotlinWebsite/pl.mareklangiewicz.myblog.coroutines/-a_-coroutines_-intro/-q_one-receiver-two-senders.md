---
title: A_Coroutines_Intro.Q_oneReceiverTwoSenders - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">Q_oneReceiverTwoSenders</a></div>

# Q_oneReceiverTwoSenders

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">Q_oneReceiverTwoSenders</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

One receiver, two senders

``` kotlin
sample {
        val channel = Channel<String>()
        launch(context) { channel.sendPeriodically("foo200", 200) }
        launch(context) { channel.sendPeriodically("BAR500", 500) }
        for (s in channel.take(context, 6))
            s.p
    }
```

