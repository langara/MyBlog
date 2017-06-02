---
title: A_Coroutines_Intro.filter - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">filter</a></div>

# filter

<div class="signature"><code><span class="keyword">fun </span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span> <span class="identifier">ReceiveChannel</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span><span class="symbol">.</span><span class="identifier">filter</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$filter(kotlinx.coroutines.experimental.channels.ReceiveChannel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.filter.T)), kotlin.coroutines.experimental.CoroutineContext, kotlin.coroutines.SuspendFunction1((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.filter.T, kotlin.Boolean)))/context">context</span><span class="symbol">:</span>&nbsp;<span class="identifier">CoroutineContext</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$filter(kotlinx.coroutines.experimental.channels.ReceiveChannel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.filter.T)), kotlin.coroutines.experimental.CoroutineContext, kotlin.coroutines.SuspendFunction1((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.filter.T, kotlin.Boolean)))/predicate">predicate</span><span class="symbol">:</span>&nbsp;<span class="identifier">SuspendFunction1</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">,</span>&nbsp;<span class="identifier">Boolean</span><span class="symbol">&gt;</span><br/><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">ProducerJob</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span></code></div>

Simple filter implementation for channels

