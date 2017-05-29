[pl.mareklangiewicz.myblog.coroutines](../../index.md) / [A_Coroutines_Intro](../index.md) / [RxSubscriber](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`RxSubscriber(block: @ExtensionFunctionType SuspendFunction1<`[`Receiver`](../-receiver/index.md)`<T>, Unit>)`

Wraps a coroutine block in rx subscriber class.

Returned subscriber can be used in [Flowable.subscribe](#)
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

