---
title: A_Coroutines_Intro.E_extractSuspendingFunction - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">E_extractSuspendingFunction</a></div>

# E_extractSuspendingFunction

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">E_extractSuspendingFunction</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Extract suspending function

FIXME: this throws an exception and I don't know why...

``` kotlin
sample {
        val job = launch(CommonPool) {
            delayAndPrintWorld()
        }
        "Hello,".p
        job.join() // this suspending function (join) waits for job to finish
    }
```

