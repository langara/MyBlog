---
title: A_Coroutines_Intro.fibonacci - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">fibonacci</a></div>

# fibonacci

<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">fibonacci</span><span class="symbol">(</span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$fibonacci(kotlin.Int, kotlinx.coroutines.experimental.channels.SendChannel((kotlin.Int)))/n">n</span><span class="symbol">:</span>&nbsp;<span class="identifier">Int</span><span class="symbol">, </span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$fibonacci(kotlin.Int, kotlinx.coroutines.experimental.channels.SendChannel((kotlin.Int)))/c">c</span><span class="symbol">:</span>&nbsp;<span class="identifier">SendChannel</span><span class="symbol">&lt;</span><span class="identifier">Int</span><span class="symbol">&gt;</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Fibonacci numbers generator

Sends given number of Fibonacci numbers to given <a href="#">SendChannel</a>

