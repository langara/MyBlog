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

### Properties

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">
<a href="p.html">p</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">val </span><span class="identifier">String</span><span class="symbol">.</span><span class="identifier">p</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Print given string with "Coroutines Intro" prefix and with current time in square brackets


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
<a href="-h_cancel-job-correctly.html">H_cancelJobCorrectly</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">H_cancelJobCorrectly</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Cancel coroutine with Job.cancel


</td>
</tr>
<tr>
<td markdown="1">
<a href="-i_cancellation-is-cooperative_1.html">I_cancellationIsCooperative_1</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">I_cancellationIsCooperative_1</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Cancellation is cooperative 1


</td>
</tr>
<tr>
<td markdown="1">
<a href="-i_cancellation-is-cooperative_2.html">I_cancellationIsCooperative_2</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">I_cancellationIsCooperative_2</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Cancellation is cooperative 2


</td>
</tr>
<tr>
<td markdown="1">
<a href="-j_under-the-hood_1.html">J_underTheHood_1</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">J_underTheHood_1</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Under the hood test


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
<tr>
<td markdown="1">
<a href="get-current-time-string.html">getCurrentTimeString</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">getCurrentTimeString</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">String</span></code></div>

Current system time as a string


</td>
</tr>
</tbody>
</table>
