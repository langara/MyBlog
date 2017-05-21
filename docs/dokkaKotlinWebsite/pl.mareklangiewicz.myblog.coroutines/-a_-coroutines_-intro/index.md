---
title: A_Coroutines_Intro - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href=".">A_Coroutines_Intro</a></div>

# A_Coroutines_Intro

<div class="signature"><code><span class="keyword">class </span><span class="identifier">A_Coroutines_Intro</span></code></div>

Kotlin Coroutines Intro in "TDD" (kind of..)

This is my attempt to learn about kotlin coroutines and write some tests on the way.

The content here is based on <a href="https://github.com/Kotlin/kotlinx.coroutines/blob/master/coroutines-guide.md">Coroutines Guide</a>
but here it is both: **documentation** and **runnable code** in **one place**.

### Constructors

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">
<a href="-init-.html">&lt;init&gt;</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="identifier">A_Coroutines_Intro</span><span class="symbol">(</span><span class="symbol">)</span></code></div>

Kotlin Coroutines Intro in "TDD" (kind of..)


</td>
</tr>
</tbody>
</table>

### Functions

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">
<a href="-a_basics.html">A_basics</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">A_basics</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

First coroutine


</td>
</tr>
<tr>
<td markdown="1">
<a href="-b_run-blocking.html">B_runBlocking</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">B_runBlocking</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Bridging blocking and nonblocking worlds


</td>
</tr>
<tr>
<td markdown="1">
<a href="-c_sample-convention.html">C_sampleConvention</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">C_sampleConvention</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Some convention for future samples/experiments/tests


</td>
</tr>
<tr>
<td markdown="1">
<a href="-d_introduce-job.html">D_introduceJob</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">D_introduceJob</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Use Job class to handle coroutine state and to wait (non blocking) for it to finish


</td>
</tr>
<tr>
<td markdown="1">
<a href="-e_extract-suspending-function.html">E_extractSuspendingFunction</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">E_extractSuspendingFunction</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Extract suspending function


</td>
</tr>
<tr>
<td markdown="1">
<a href="-f_coroutines-are-lightweight.html">F_coroutinesAreLightweight</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">F_coroutinesAreLightweight</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Run 100 000 coroutines in parallel


</td>
</tr>
<tr>
<td markdown="1">
<a href="-g_exit-while-coroutine-still-active.html">G_exitWhileCoroutineStillActive</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">G_exitWhileCoroutineStillActive</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Active coroutines are terminated when the whole process ends (like daemon threads)


</td>
</tr>
<tr>
<td markdown="1">
<a href="delay-and-print-world.html">delayAndPrintWorld</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">delayAndPrintWorld</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Extracted fun delayAndPrintWorld


</td>
</tr>
</tbody>
</table>
