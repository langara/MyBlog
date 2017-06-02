---
title: A_Coroutines_Intro.P_producePrimeNumbers - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">P_producePrimeNumbers</a></div>

# P_producePrimeNumbers

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">P_producePrimeNumbers</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Generate prime numbers with crazy channels pipeline

``` kotlin
sample {
        var cur = produceNumbersFrom(CommonPool, 2)
        for (i in 1..20) {
            val prime = cur.receive()
            "prime: $prime".p
            cur = cur.filter(context) { it % prime != 0 }
        }
    }
```

