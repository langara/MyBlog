---
title: A_Coroutines_Intro.mydelay - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="index.html">A_Coroutines_Intro</a> / <a href=".">mydelay</a></div>

# mydelay

<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">mydelay</span><span class="symbol">(</span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$mydelay(kotlin.Long)/time">time</span><span class="symbol">:</span>&nbsp;<span class="identifier">Long</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Simple suspending function implementation

Important: the "return" keyword (or expression body syntax) is necessary here.
Without "return" it returns from suspension more than once.. looks like bug in state machine generation

