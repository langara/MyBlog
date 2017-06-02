---
title: A_Coroutines_Intro.massiveRun - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">massiveRun</a></div>

# massiveRun

<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">massiveRun</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$massiveRun(kotlin.coroutines.experimental.CoroutineContext, kotlin.coroutines.SuspendFunction0((kotlin.Unit)))/context">context</span><span class="symbol">:</span>&nbsp;<span class="identifier">CoroutineContext</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$massiveRun(kotlin.coroutines.experimental.CoroutineContext, kotlin.coroutines.SuspendFunction0((kotlin.Unit)))/action">action</span><span class="symbol">:</span>&nbsp;<span class="identifier">SuspendFunction0</span><span class="symbol">&lt;</span><span class="identifier">Unit</span><span class="symbol">&gt;</span><br/><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Runs given action a million times using thousand coroutines

``` kotlin
val n = 1000 // number of coroutines to launch
val k = 1000 // times an action is repeated by each coroutine
val time = measureTimeMillis {
    val jobs = List(n) {
        launch(context) {
            repeat(k) { action() }
        }
    }
    jobs.forEach { it.join() }
}
```

