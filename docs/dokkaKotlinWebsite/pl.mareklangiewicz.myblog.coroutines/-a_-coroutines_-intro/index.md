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
<a href="-j_under-the-hood_2.html">J_underTheHood_2</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">J_underTheHood_2</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Under the hood test 2 without using kotlinx stuff
FIXME NOW: this doesn't work correctly (it logs too much)!


</td>
</tr>
<tr>
<td markdown="1">
<a href="-j_under-the-hood_3.html">J_underTheHood_3</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">J_underTheHood_3</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Under the hood - error case investigation
FIXME NOW: this example should never print "coroutine end", but it does immediately!


</td>
</tr>
<tr>
<td markdown="1">
<a href="-k_sequence.html">K_sequence</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">K_sequence</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Sequence builder test


</td>
</tr>
<tr>
<td markdown="1">
<a href="-l_completable-future.html">L_completableFuture</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">L_completableFuture</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Wrap coroutine in completable future


</td>
</tr>
<tr>
<td markdown="1">
<a href="-l_completable-future_2.html">L_completableFuture_2</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">L_completableFuture_2</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Wrap coroutine in LAZY completable future


</td>
</tr>
<tr>
<td markdown="1">
<a href="-l_completable-future_3.html">L_completableFuture_3</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">L_completableFuture_3</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Wrap futures in suspension points


</td>
</tr>
<tr>
<td markdown="1">
<a href="create-future.html">createFuture</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span> <span class="identifier">createFuture</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$createFuture(kotlin.coroutines.SuspendFunction0((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.createFuture.T)))/block">block</span><span class="symbol">:</span>&nbsp;<span class="identifier">SuspendFunction0</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span><br/><span class="symbol">)</span><span class="symbol">: </span><a href="http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html"><span class="identifier">CompletableFuture</span></a><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span></code></div>

Create (and start) a future representing a coroutine


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
<tr>
<td markdown="1">
<a href="prepare-future.html">prepareFuture</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span> <span class="identifier">prepareFuture</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$prepareFuture(kotlin.coroutines.SuspendFunction0((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.prepareFuture.T)))/block">block</span><span class="symbol">:</span>&nbsp;<span class="identifier">SuspendFunction0</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span><br/><span class="symbol">)</span><span class="symbol">: </span><span class="symbol">(</span><span class="symbol">)</span>&nbsp;<span class="symbol">-&gt;</span>&nbsp;<a href="http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html"><span class="identifier">CompletableFuture</span></a><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span></code></div>

Prepare a future representing a coroutine


</td>
</tr>
<tr>
<td markdown="1">
<a href="suspend.html">suspend</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span> <a href="http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html"><span class="identifier">CompletableFuture</span></a><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span><span class="symbol">.</span><span class="identifier">suspend</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">T</span></code></div>

Wrap future in suspension point


</td>
</tr>
</tbody>
</table>
