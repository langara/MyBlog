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

### Types

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">
<a href="-ball/index.html">Ball</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">data</span> <span class="keyword">class </span><span class="identifier">Ball</span></code></div>

A ball in ping pong game


</td>
</tr>
<tr>
<td markdown="1">
<a href="-receiver/index.html">Receiver</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">interface </span><span class="identifier">Receiver</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span>&nbsp;<span class="symbol">:</span>&nbsp;<a href="http://docs.oracle.com/javase/6/docs/api/java/lang/AutoCloseable.html"><span class="identifier">AutoCloseable</span></a></code></div>

Something that you can ask for items, but it can suspend when item is not available yet


</td>
</tr>
<tr>
<td markdown="1">
<a href="-rx-subscriber/index.html">RxSubscriber</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">class </span><span class="identifier">RxSubscriber</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span>&nbsp;<span class="symbol">:</span>&nbsp;<span class="identifier">Subscriber</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span></code></div>

Wraps a coroutine block in rx subscriber class.


</td>
</tr>
</tbody>
</table>

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
<div class="signature"><code><span class="keyword">val </span><span class="identifier">Any</span><span class="symbol">.</span><span class="identifier">p</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

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
<a href="-e_coroutine-is-sequential.html">E_coroutineIsSequential</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">E_coroutineIsSequential</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Suspending functions are called sequentially


</td>
</tr>
<tr>
<td markdown="1">
<a href="-e_coroutine-parallel.html">E_coroutineParallel</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">E_coroutineParallel</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Run suspending functions in parallel


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
<a href="-e_lazy-async.html">E_lazyAsync</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">E_lazyAsync</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Run suspending functions in parallel, but lazily


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
<a href="-i-a_contexts.html">IA_contexts</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">IA_contexts</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Different contexts example


</td>
</tr>
<tr>
<td markdown="1">
<a href="-i-a_contexts_2.html">IA_contexts_2</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">IA_contexts_2</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

run and runBlocking with specified context


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
<a href="-i_cancellation-is-cooperative_3_with-timeout.html">I_cancellationIsCooperative_3_withTimeout</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">I_cancellationIsCooperative_3_withTimeout</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Cancellation with timeout


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


</td>
</tr>
<tr>
<td markdown="1">
<a href="-j_under-the-hood_3.html">J_underTheHood_3</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">J_underTheHood_3</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Under the hood - error case investigation


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
<a href="-l_completable-future_4.html">L_completableFuture_4</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">L_completableFuture_4</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Use future related functions from kotlinx.coroutines


</td>
</tr>
<tr>
<td markdown="1">
<a href="-l_completable-future_5.html">L_completableFuture_5</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">L_completableFuture_5</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Use prepareFuture to make last example more lazy and simple


</td>
</tr>
<tr>
<td markdown="1">
<a href="-m_rx-subscriber.html">M_rxSubscriber</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">M_rxSubscriber</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Implement rx subscriber wrapping coroutine block


</td>
</tr>
<tr>
<td markdown="1">
<a href="-n_fibonacci-channels.html">N_fibonacciChannels</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">N_fibonacciChannels</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Use channels to implement fibonacci numbers generator


</td>
</tr>
<tr>
<td markdown="1">
<a href="-o_produce-channel.html">O_produceChannel</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">O_produceChannel</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Use <code>produce</code> utility function


</td>
</tr>
<tr>
<td markdown="1">
<a href="-p_produce-prime-numbers.html">P_producePrimeNumbers</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">P_producePrimeNumbers</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Generate prime numbers with crazy channels pipeline


</td>
</tr>
<tr>
<td markdown="1">
<a href="-q_one-receiver-two-senders.html">Q_oneReceiverTwoSenders</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">Q_oneReceiverTwoSenders</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

One receiver, two senders


</td>
</tr>
<tr>
<td markdown="1">
<a href="-q_one-sender-five-receivers.html">Q_oneSenderFiveReceivers</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">Q_oneSenderFiveReceivers</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

One sender, five receivers


</td>
</tr>
<tr>
<td markdown="1">
<a href="-r_channels-are-fair.html">R_channelsAreFair</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">R_channelsAreFair</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Channels are fair


</td>
</tr>
<tr>
<td markdown="1">
<a href="-r_massive-nonsync-action.html">R_massiveNonsyncAction</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">R_massiveNonsyncAction</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Massive non sync action


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
<a href="delay-and-return7.html">delayAndReturn7</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">delayAndReturn7</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Int</span></code></div>

Delay and return 7 with logging


</td>
</tr>
<tr>
<td markdown="1">
<a href="delay-and-return8.html">delayAndReturn8</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">delayAndReturn8</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Int</span></code></div>

Delay and return 8 with logging


</td>
</tr>
<tr>
<td markdown="1">
<a href="fibonacci.html">fibonacci</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">fibonacci</span><span class="symbol">(</span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$fibonacci(kotlin.Int, kotlinx.coroutines.experimental.channels.SendChannel((kotlin.Int)))/n">n</span><span class="symbol">:</span>&nbsp;<span class="identifier">Int</span><span class="symbol">, </span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$fibonacci(kotlin.Int, kotlinx.coroutines.experimental.channels.SendChannel((kotlin.Int)))/c">c</span><span class="symbol">:</span>&nbsp;<span class="identifier">SendChannel</span><span class="symbol">&lt;</span><span class="identifier">Int</span><span class="symbol">&gt;</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Fibonacci numbers generator


</td>
</tr>
<tr>
<td markdown="1">
<a href="filter.html">filter</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span> <span class="identifier">ReceiveChannel</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span><span class="symbol">.</span><span class="identifier">filter</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$filter(kotlinx.coroutines.experimental.channels.ReceiveChannel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.filter.T)), kotlin.coroutines.experimental.CoroutineContext, kotlin.coroutines.SuspendFunction1((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.filter.T, kotlin.Boolean)))/context">context</span><span class="symbol">:</span>&nbsp;<span class="identifier">CoroutineContext</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$filter(kotlinx.coroutines.experimental.channels.ReceiveChannel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.filter.T)), kotlin.coroutines.experimental.CoroutineContext, kotlin.coroutines.SuspendFunction1((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.filter.T, kotlin.Boolean)))/predicate">predicate</span><span class="symbol">:</span>&nbsp;<span class="identifier">SuspendFunction1</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">,</span>&nbsp;<span class="identifier">Boolean</span><span class="symbol">&gt;</span><br/><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">ProducerJob</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span></code></div>

Simple filter implementation for channels


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
<a href="massive-run.html">massiveRun</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">massiveRun</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$massiveRun(kotlin.coroutines.experimental.CoroutineContext, kotlin.coroutines.SuspendFunction0((kotlin.Unit)))/context">context</span><span class="symbol">:</span>&nbsp;<span class="identifier">CoroutineContext</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$massiveRun(kotlin.coroutines.experimental.CoroutineContext, kotlin.coroutines.SuspendFunction0((kotlin.Unit)))/action">action</span><span class="symbol">:</span>&nbsp;<span class="identifier">SuspendFunction0</span><span class="symbol">&lt;</span><span class="identifier">Unit</span><span class="symbol">&gt;</span><br/><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Runs given action a million times using thousand coroutines


</td>
</tr>
<tr>
<td markdown="1">
<a href="mydelay.html">mydelay</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">mydelay</span><span class="symbol">(</span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$mydelay(kotlin.Long)/time">time</span><span class="symbol">:</span>&nbsp;<span class="identifier">Long</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Simple suspending function implementation


</td>
</tr>
<tr>
<td markdown="1">
<a href="mynever1.html">mynever1</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">mynever1</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Should suspend forever (but it does not)


</td>
</tr>
<tr>
<td markdown="1">
<a href="mynever2.html">mynever2</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">mynever2</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Correctly suspends forever


</td>
</tr>
<tr>
<td markdown="1">
<a href="player.html">player</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="identifier">player</span><span class="symbol">(</span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$player(kotlin.String, kotlinx.coroutines.experimental.channels.Channel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.Ball)))/name">name</span><span class="symbol">:</span>&nbsp;<span class="identifier">String</span><span class="symbol">, </span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$player(kotlin.String, kotlinx.coroutines.experimental.channels.Channel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.Ball)))/table">table</span><span class="symbol">:</span>&nbsp;<span class="identifier">Channel</span><span class="symbol">&lt;</span><a href="-ball/index.html"><span class="identifier">Ball</span></a><span class="symbol">&gt;</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

A player in ping pong game


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
<a href="process-all.html">processAll</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span> <span class="identifier">ReceiveChannel</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span><span class="symbol">.</span><span class="identifier">processAll</span><span class="symbol">(</span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$processAll(kotlinx.coroutines.experimental.channels.ReceiveChannel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.processAll.T)), kotlin.Int)/id">id</span><span class="symbol">:</span>&nbsp;<span class="identifier">Int</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Job</span></code></div>

Prints all received values from given channel with "processor #id" prefix


</td>
</tr>
<tr>
<td markdown="1">
<a href="produce-numbers-from.html">produceNumbersFrom</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">produceNumbersFrom</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$produceNumbersFrom(kotlin.coroutines.experimental.CoroutineContext, kotlin.Int)/context">context</span><span class="symbol">:</span>&nbsp;<span class="identifier">CoroutineContext</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$produceNumbersFrom(kotlin.coroutines.experimental.CoroutineContext, kotlin.Int)/from">from</span><span class="symbol">:</span>&nbsp;<span class="identifier">Int</span><br/><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">ProducerJob</span><span class="symbol">&lt;</span><span class="identifier">Int</span><span class="symbol">&gt;</span></code></div>

Produces successive numbers


</td>
</tr>
<tr>
<td markdown="1">
<a href="send-periodically.html">sendPeriodically</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">suspend</span> <span class="keyword">fun </span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span> <span class="identifier">SendChannel</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span><span class="symbol">.</span><span class="identifier">sendPeriodically</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$sendPeriodically(kotlinx.coroutines.experimental.channels.SendChannel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.sendPeriodically.T)), pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.sendPeriodically.T, kotlin.Long)/t">t</span><span class="symbol">:</span>&nbsp;<span class="identifier">T</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$sendPeriodically(kotlinx.coroutines.experimental.channels.SendChannel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.sendPeriodically.T)), pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.sendPeriodically.T, kotlin.Long)/delay">delay</span><span class="symbol">:</span>&nbsp;<span class="identifier">Long</span><br/><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Sends given value indefinitely


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
<tr>
<td markdown="1">
<a href="take.html">take</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span> <span class="identifier">ReceiveChannel</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span><span class="symbol">.</span><span class="identifier">take</span><span class="symbol">(</span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$take(kotlinx.coroutines.experimental.channels.ReceiveChannel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.take.T)), kotlin.coroutines.experimental.CoroutineContext, kotlin.Long)/context">context</span><span class="symbol">:</span>&nbsp;<span class="identifier">CoroutineContext</span><span class="symbol">, </span><br/>&nbsp;&nbsp;&nbsp;&nbsp;<span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro$take(kotlinx.coroutines.experimental.channels.ReceiveChannel((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.take.T)), kotlin.coroutines.experimental.CoroutineContext, kotlin.Long)/size">size</span><span class="symbol">:</span>&nbsp;<span class="identifier">Long</span><br/><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">ProducerJob</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span></code></div>

Take specified number of items from channel and send it further


</td>
</tr>
</tbody>
</table>
