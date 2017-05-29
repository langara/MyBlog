---
title: A_Coroutines_Intro.Receiver - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="../index.html">A_Coroutines_Intro</a> / <a href=".">Receiver</a></div>

# Receiver

<div class="signature"><code><span class="keyword">interface </span><span class="identifier">Receiver</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span>&nbsp;<span class="symbol">:</span>&nbsp;<a href="http://docs.oracle.com/javase/6/docs/api/java/lang/AutoCloseable.html"><span class="identifier">AutoCloseable</span></a></code></div>

Something that you can ask for items, but it can suspend when item is not available yet

``` kotlin
/**
     * Something that you can ask for items, but it can suspend when item is not available yet
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.Receiver
     */
    interface Receiver<T> : AutoCloseable {
        /**
         * Receives next item immediately or suspends if no item is ready
         */
        suspend fun receive(): T
    }
```

### Functions

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">
<a href="receive.html">receive</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">abstract</span> <span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">receive</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">T</span></code></div>

Receives next item immediately or suspends if no item is ready


</td>
</tr>
</tbody>
</table>
