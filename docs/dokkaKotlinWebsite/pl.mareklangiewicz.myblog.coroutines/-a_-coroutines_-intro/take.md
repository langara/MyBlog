---
title: A_Coroutines_Intro.take - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">take</a></div>

# take

<div class="signature"><code><span class="keyword">fun </span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span> <span class="identifier">ReceiveChannel</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span><span class="symbol">.</span><span class="identifier">take</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$take(kotlinx.coroutines.experimental.channels.ReceiveChannel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.take.T)), kotlin.coroutines.experimental.CoroutineContext, kotlin.Long)/context">context</span><span class="symbol">:</span>&nbsp;<span class="identifier">CoroutineContext</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$take(kotlinx.coroutines.experimental.channels.ReceiveChannel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.take.T)), kotlin.coroutines.experimental.CoroutineContext, kotlin.Long)/size">size</span><span class="symbol">:</span>&nbsp;<span class="identifier">Long</span><br/><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">ProducerJob</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span></code></div>

Take specified number of items from channel and send it further

