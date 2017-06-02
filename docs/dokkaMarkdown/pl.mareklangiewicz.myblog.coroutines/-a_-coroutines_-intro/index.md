[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](.)

# A_Coroutines_Intro

`class A_Coroutines_Intro`

Kotlin Coroutines Intro in "TDD" (kind of..)

This is my attempt to learn about kotlin coroutines and write some tests on the way.

The content here is based on [Coroutines Guide](https://github.com/Kotlin/kotlinx.coroutines/blob/master/coroutines-guide.md)
but here it is both: **documentation** and **runnable code** in **one place**.

### Types

| [Ball](-ball/index.md) | `data class Ball`<br>A ball in ping pong game |
| [Receiver](-receiver/index.md) | `interface Receiver<T> : `[`AutoCloseable`](http://docs.oracle.com/javase/6/docs/api/java/lang/AutoCloseable.html)<br>Something that you can ask for items, but it can suspend when item is not available yet |
| [RxSubscriber](-rx-subscriber/index.md) | `class RxSubscriber<T> : Subscriber<T>`<br>Wraps a coroutine block in rx subscriber class. |

### Constructors

| [&lt;init&gt;](-init-.md) | `A_Coroutines_Intro()`<br>Kotlin Coroutines Intro in "TDD" (kind of..) |

### Properties

| [p](p.md) | `val Any.p: Unit`<br>Print given string with "Coroutines Intro" prefix and with current time in square brackets |

### Functions

| [A_basics](-a_basics.md) | `fun A_basics(): Unit`<br>First coroutine |
| [B_runBlocking](-b_run-blocking.md) | `fun B_runBlocking(): Unit`<br>Bridging blocking and nonblocking worlds |
| [C_sampleConvention](-c_sample-convention.md) | `fun C_sampleConvention(): Unit`<br>Some convention for future samples/experiments/tests |
| [D_introduceJob](-d_introduce-job.md) | `fun D_introduceJob(): Unit`<br>Use Job class to handle coroutine state and to wait (non blocking) for it to finish |
| [E_coroutineIsSequential](-e_coroutine-is-sequential.md) | `fun E_coroutineIsSequential(): Unit`<br>Suspending functions are called sequentially |
| [E_coroutineParallel](-e_coroutine-parallel.md) | `fun E_coroutineParallel(): Unit`<br>Run suspending functions in parallel |
| [E_extractSuspendingFunction](-e_extract-suspending-function.md) | `fun E_extractSuspendingFunction(): Unit`<br>Extract suspending function |
| [E_lazyAsync](-e_lazy-async.md) | `fun E_lazyAsync(): Unit`<br>Run suspending functions in parallel, but lazily |
| [F_coroutinesAreLightweight](-f_coroutines-are-lightweight.md) | `fun F_coroutinesAreLightweight(): Unit`<br>Run 100 000 coroutines in parallel |
| [G_exitWhileCoroutineStillActive](-g_exit-while-coroutine-still-active.md) | `fun G_exitWhileCoroutineStillActive(): Unit`<br>Active coroutines are terminated when the whole process ends (like daemon threads) |
| [H_cancelJobCorrectly](-h_cancel-job-correctly.md) | `fun H_cancelJobCorrectly(): Unit`<br>Cancel coroutine with Job.cancel |
| [IA_contexts](-i-a_contexts.md) | `fun IA_contexts(): Unit`<br>Different contexts example |
| [IA_contexts_2](-i-a_contexts_2.md) | `fun IA_contexts_2(): Unit`<br>run and runBlocking with specified context |
| [I_cancellationIsCooperative_1](-i_cancellation-is-cooperative_1.md) | `fun I_cancellationIsCooperative_1(): Unit`<br>Cancellation is cooperative 1 |
| [I_cancellationIsCooperative_2](-i_cancellation-is-cooperative_2.md) | `fun I_cancellationIsCooperative_2(): Unit`<br>Cancellation is cooperative 2 |
| [I_cancellationIsCooperative_3_withTimeout](-i_cancellation-is-cooperative_3_with-timeout.md) | `fun I_cancellationIsCooperative_3_withTimeout(): Unit`<br>Cancellation with timeout |
| [J_underTheHood_1](-j_under-the-hood_1.md) | `fun J_underTheHood_1(): Unit`<br>Under the hood test |
| [J_underTheHood_2](-j_under-the-hood_2.md) | `fun J_underTheHood_2(): Unit`<br>Under the hood test 2 without using kotlinx stuff |
| [J_underTheHood_3](-j_under-the-hood_3.md) | `fun J_underTheHood_3(): Unit`<br>Under the hood - error case investigation |
| [K_sequence](-k_sequence.md) | `fun K_sequence(): Unit`<br>Sequence builder test |
| [L_completableFuture](-l_completable-future.md) | `fun L_completableFuture(): Unit`<br>Wrap coroutine in completable future |
| [L_completableFuture_2](-l_completable-future_2.md) | `fun L_completableFuture_2(): Unit`<br>Wrap coroutine in LAZY completable future |
| [L_completableFuture_3](-l_completable-future_3.md) | `fun L_completableFuture_3(): Unit`<br>Wrap futures in suspension points |
| [L_completableFuture_4](-l_completable-future_4.md) | `fun L_completableFuture_4(): Unit`<br>Use future related functions from kotlinx.coroutines |
| [L_completableFuture_5](-l_completable-future_5.md) | `fun L_completableFuture_5(): Unit`<br>Use prepareFuture to make last example more lazy and simple |
| [M_rxSubscriber](-m_rx-subscriber.md) | `fun M_rxSubscriber(): Unit`<br>Implement rx subscriber wrapping coroutine block |
| [N_fibonacciChannels](-n_fibonacci-channels.md) | `fun N_fibonacciChannels(): Unit`<br>Use channels to implement fibonacci numbers generator |
| [O_produceChannel](-o_produce-channel.md) | `fun O_produceChannel(): Unit`<br>Use `produce` utility function |
| [P_producePrimeNumbers](-p_produce-prime-numbers.md) | `fun P_producePrimeNumbers(): Unit`<br>Generate prime numbers with crazy channels pipeline |
| [Q_oneReceiverTwoSenders](-q_one-receiver-two-senders.md) | `fun Q_oneReceiverTwoSenders(): Unit`<br>One receiver, two senders |
| [Q_oneSenderFiveReceivers](-q_one-sender-five-receivers.md) | `fun Q_oneSenderFiveReceivers(): Unit`<br>One sender, five receivers |
| [R_channelsAreFair](-r_channels-are-fair.md) | `fun R_channelsAreFair(): Unit`<br>Channels are fair |
| [R_massiveNonsyncAction](-r_massive-nonsync-action.md) | `fun R_massiveNonsyncAction(): Unit`<br>Massive non sync action |
| [createFuture](create-future.md) | `fun <T> createFuture(block: SuspendFunction0<T>): `[`CompletableFuture`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html)`<T>`<br>Create (and start) a future representing a coroutine |
| [delayAndPrintWorld](delay-and-print-world.md) | `suspend fun delayAndPrintWorld(): Unit`<br>Extracted fun delayAndPrintWorld |
| [delayAndReturn7](delay-and-return7.md) | `suspend fun delayAndReturn7(): Int`<br>Delay and return 7 with logging |
| [delayAndReturn8](delay-and-return8.md) | `suspend fun delayAndReturn8(): Int`<br>Delay and return 8 with logging |
| [fibonacci](fibonacci.md) | `suspend fun fibonacci(n: Int, c: SendChannel<Int>): Unit`<br>Fibonacci numbers generator |
| [filter](filter.md) | `fun <T> ReceiveChannel<T>.filter(context: CoroutineContext, predicate: SuspendFunction1<T, Boolean>): ProducerJob<T>`<br>Simple filter implementation for channels |
| [getCurrentTimeString](get-current-time-string.md) | `fun getCurrentTimeString(): String`<br>Current system time as a string |
| [massiveRun](massive-run.md) | `suspend fun massiveRun(context: CoroutineContext, action: SuspendFunction0<Unit>): Unit`<br>Runs given action a million times using thousand coroutines |
| [mydelay](mydelay.md) | `suspend fun mydelay(time: Long): Unit`<br>Simple suspending function implementation |
| [mynever1](mynever1.md) | `suspend fun mynever1(): Unit`<br>Should suspend forever (but it does not) |
| [mynever2](mynever2.md) | `suspend fun mynever2(): Unit`<br>Correctly suspends forever |
| [player](player.md) | `suspend fun player(name: String, table: Channel<`[`Ball`](-ball/index.md)`>): Unit`<br>A player in ping pong game |
| [prepareFuture](prepare-future.md) | `fun <T> prepareFuture(block: SuspendFunction0<T>): () -> `[`CompletableFuture`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html)`<T>`<br>Prepare a future representing a coroutine |
| [processAll](process-all.md) | `fun <T> ReceiveChannel<T>.processAll(id: Int): Job`<br>Prints all received values from given channel with "processor #id" prefix |
| [produceNumbersFrom](produce-numbers-from.md) | `fun produceNumbersFrom(context: CoroutineContext, from: Int): ProducerJob<Int>`<br>Produces successive numbers |
| [sendPeriodically](send-periodically.md) | `suspend fun <T> SendChannel<T>.sendPeriodically(t: T, delay: Long): Unit`<br>Sends given value indefinitely |
| [suspend](suspend.md) | `suspend fun <T> `[`CompletableFuture`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html)`<T>.suspend(): T`<br>Wrap future in suspension point |
| [take](take.md) | `fun <T> ReceiveChannel<T>.take(context: CoroutineContext, size: Long): ProducerJob<T>`<br>Take specified number of items from channel and send it further |

