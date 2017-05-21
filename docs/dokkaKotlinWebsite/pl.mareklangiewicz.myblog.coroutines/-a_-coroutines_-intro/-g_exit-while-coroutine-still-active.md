---
title: A_Coroutines_Intro.G_exitWhileCoroutineStillActive - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">G_exitWhileCoroutineStillActive</a></div>

# G_exitWhileCoroutineStillActive

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">G_exitWhileCoroutineStillActive</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Active coroutines are terminated when the whole process ends (like daemon threads)

``` kotlin
sample {
        launch(CommonPool) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(1300L) // just quit after delay
    }
```

