---
title: A_Coroutines_Intro.RxSubscriber - 
layout: api
---

<div class='api-docs-breadcrumbs'><a href="../../index.html">pl.mareklangiewicz.myblog.coroutines</a> / <a href="../index.html">A_Coroutines_Intro</a> / <a href=".">RxSubscriber</a></div>

# RxSubscriber

<div class="signature"><code><span class="keyword">class </span><span class="identifier">RxSubscriber</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span>&nbsp;<span class="symbol">:</span>&nbsp;<span class="identifier">Subscriber</span><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span></code></div>

Wraps a coroutine block in rx subscriber class.

Returned subscriber can be used in <a href="#">Flowable.subscribe</a>
It honors back pressure correctly

``` kotlin
/**
     * Wraps a coroutine block in rx subscriber class.
     *
     * Returned subscriber can be used in [Flowable.subscribe]
     * It honors back pressure correctly
     *
     * @sample pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.RxSubscriber
     */
    class RxSubscriber<T>(private val block: suspend Receiver<T>.() -> Unit) : Subscriber<T> {
        private lateinit var subscription: Subscription
        private lateinit var continuation: Continuation<T>
        private val receiver = object : Receiver<T> {
            suspend override fun receive(): T = suspendCoroutine {
                continuation = it
                subscription.request(1)
            }
            override fun close() = subscription.cancel()
        }
        private val completion = object : Continuation<Unit> {
            override val context = EmptyCoroutineContext
            override fun resume(value: Unit) {
                subscription.cancel()
            }
            override fun resumeWithException(exception: Throwable) {
                subscription.cancel()
            }
        }
        /**
         * Starts the coroutine
         */
        override fun onSubscribe(subscription: Subscription) {
            this.subscription = subscription
            block.startCoroutine(receiver, completion)
        }
        /**
         * Resumes the coroutine with given item
         */
        override fun onNext(t: T) = continuation.resume(t)
        /**
         * Resumes the coroutine with given exception
         */
        override fun onError(t: Throwable) = continuation.resumeWithException(t)
        /**
         * Does nothing
         */
        override fun onComplete() = Unit
    }
```

### Constructors

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">
<a href="-init-.html">&lt;init&gt;</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="identifier">RxSubscriber</span><span class="symbol">(</span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.RxSubscriber$<init>(kotlin.coroutines.SuspendFunction1((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.Receiver((pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.RxSubscriber.T)), kotlin.Unit)))/block">block</span><span class="symbol">:</span>&nbsp;<span class="identifier">SuspendFunction1</span><span class="symbol">&lt;</span><a href="../-receiver/index.html"><span class="identifier">Receiver</span></a><span class="symbol">&lt;</span><span class="identifier">T</span><span class="symbol">&gt;</span><span class="symbol">,</span>&nbsp;<span class="identifier">Unit</span><span class="symbol">&gt;</span><span class="symbol">)</span></code></div>

Wraps a coroutine block in rx subscriber class.


</td>
</tr>
</tbody>
</table>

### Functions

<table class="api-docs-table">
<tbody>
<tr>
<td markdown="1">
<a href="on-complete.html">onComplete</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">onComplete</span><span class="symbol">(</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Does nothing


</td>
</tr>
<tr>
<td markdown="1">
<a href="on-error.html">onError</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">onError</span><span class="symbol">(</span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.RxSubscriber$onError(kotlin.Throwable)/t">t</span><span class="symbol">:</span>&nbsp;<span class="identifier">Throwable</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Resumes the coroutine with given exception


</td>
</tr>
<tr>
<td markdown="1">
<a href="on-next.html">onNext</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">onNext</span><span class="symbol">(</span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.RxSubscriber$onNext(pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.RxSubscriber.T)/t">t</span><span class="symbol">:</span>&nbsp;<span class="identifier">T</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Resumes the coroutine with given item


</td>
</tr>
<tr>
<td markdown="1">
<a href="on-subscribe.html">onSubscribe</a>
</td>
<td markdown="1">
<div class="signature"><code><span class="keyword">fun </span><span class="identifier">onSubscribe</span><span class="symbol">(</span><span class="parameterName" id="pl.mareklangiewicz.myblog.coroutines.A_Coroutines_Intro.RxSubscriber$onSubscribe(org.reactivestreams.Subscription)/subscription">subscription</span><span class="symbol">:</span>&nbsp;<span class="identifier">Subscription</span><span class="symbol">)</span><span class="symbol">: </span><span class="identifier">Unit</span></code></div>

Starts the coroutine


</td>
</tr>
</tbody>
</table>
