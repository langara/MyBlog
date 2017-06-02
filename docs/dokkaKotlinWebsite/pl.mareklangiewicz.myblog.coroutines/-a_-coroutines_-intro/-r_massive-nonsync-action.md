---
title: A_Coroutines_Intro.R_massiveNonsyncAction - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">R_massiveNonsyncAction</a></div>

# R_massiveNonsyncAction

<div class="signature"><code><span class="keyword">fun </span><span class="identifier">R_massiveNonsyncAction</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Massive non sync action

``` kotlin
sample {
        "start".p
        var counter = 0 // @Volatile would not help much; AtomicInteger would work correctly.
//        val context = newSingleThreadContext("single") // this will increment counter correctly all the times
        val context = newFixedThreadPoolContext(2, "double") // this should cause some sync errors
//        val context = CommonPool // this should cause some sync errors on systems with multiple CPUs (more than 2)
        massiveRun(context) {
            counter ++
        }
        "end. counter: $counter (should be 1000000) (error: ${1000000-counter})".p
    }
```

