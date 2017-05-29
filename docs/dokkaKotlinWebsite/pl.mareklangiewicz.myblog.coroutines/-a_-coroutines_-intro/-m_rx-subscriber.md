---
title: A_Coroutines_Intro.M_rxSubscriber - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">M_rxSubscriber</a></div>

# M_rxSubscriber

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">M_rxSubscriber</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Implement rx subscriber wrapping coroutine block

``` kotlin
        val flowable = Flowable
                .interval(300, TimeUnit.MILLISECONDS)
                .take(10)
        val subscriber = RxSubscriber<Long> {
            receive().p
//            close()
            receive().p
            receive().p
//            delay(1500)
            receive().p
            receive().p
            receive().p
        }
        flowable.subscribe(subscriber)
        Thread.sleep(10000)
```

