---
title: A_Coroutines_Intro.processAll - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">processAll</a></div>

# processAll

<div class="signature"><code><span class="keyword">fun </span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span> <span class="identifier">ReceiveChannel</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span><span class="symbol">.</span><span class="identifier">processAll</span><span class="symbol">(</span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$processAll(kotlinx.coroutines.experimental.channels.ReceiveChannel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.processAll.T)), kotlin.Int)/id">id</span><span class="symbol">:</span>&nbsp;<span class="identifier">Int</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Job</span></code></div>

Prints all received values from given channel with "processor #id" prefix

