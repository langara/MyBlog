---
title: A_Coroutines_Intro - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](.)

# A_Coroutines_Intro

`class A_Coroutines_Intro`

Kotlin Coroutines Intro in "TDD" (kind of..)

This is my attempt to learn about kotlin coroutines and write some tests on the way.

The content here is based on [Coroutines Guide](https://github.com/Kotlin/kotlinx.coroutines/blob/master/coroutines-guide.md)
but here it is both: **documentation** and **runnable code** in **one place**.

### Constructors

| [&lt;init&gt;](-init-.md) | `A_Coroutines_Intro()`<br>Kotlin Coroutines Intro in "TDD" (kind of..) |

### Properties

| [p](p.md) | `val String.p: Unit`<br>Print given string with "Coroutines Intro" prefix and with current time in square brackets |

### Functions

| [A_basics](-a_basics.md) | `fun A_basics(): Unit`<br>First coroutine |
| [B_runBlocking](-b_run-blocking.md) | `fun B_runBlocking(): Unit`<br>Bridging blocking and nonblocking worlds |
| [C_sampleConvention](-c_sample-convention.md) | `fun C_sampleConvention(): Unit`<br>Some convention for future samples/experiments/tests |
| [D_introduceJob](-d_introduce-job.md) | `fun D_introduceJob(): Unit`<br>Use Job class to handle coroutine state and to wait (non blocking) for it to finish |
| [E_extractSuspendingFunction](-e_extract-suspending-function.md) | `fun E_extractSuspendingFunction(): Unit`<br>Extract suspending function |
| [F_coroutinesAreLightweight](-f_coroutines-are-lightweight.md) | `fun F_coroutinesAreLightweight(): Unit`<br>Run 100 000 coroutines in parallel |
| [G_exitWhileCoroutineStillActive](-g_exit-while-coroutine-still-active.md) | `fun G_exitWhileCoroutineStillActive(): Unit`<br>Active coroutines are terminated when the whole process ends (like daemon threads) |
| [H_cancelJobCorrectly](-h_cancel-job-correctly.md) | `fun H_cancelJobCorrectly(): Unit`<br>Cancel coroutine with Job.cancel |
| [I_cancellationIsCooperative_1](-i_cancellation-is-cooperative_1.md) | `fun I_cancellationIsCooperative_1(): Unit`<br>Cancellation is cooperative 1 |
| [I_cancellationIsCooperative_2](-i_cancellation-is-cooperative_2.md) | `fun I_cancellationIsCooperative_2(): Unit`<br>Cancellation is cooperative 2 |
| [J_underTheHood_1](-j_under-the-hood_1.md) | `fun J_underTheHood_1(): Unit`<br>Under the hood test |
| [J_underTheHood_2](-j_under-the-hood_2.md) | `fun J_underTheHood_2(): Unit`<br>Under the hood test 2 without using kotlinx stuff
FIXME NOW: this doesn't work correctly (it logs too much)! |
| [J_underTheHood_3](-j_under-the-hood_3.md) | `fun J_underTheHood_3(): Unit`<br>Under the hood - error case investigation
FIXME NOW: this example should never print "coroutine end", but it does immediately! |
| [K_sequence](-k_sequence.md) | `fun K_sequence(): Unit`<br>Sequence builder test |
| [L_completableFuture](-l_completable-future.md) | `fun L_completableFuture(): Unit`<br>Wrap coroutine in completable future |
| [L_completableFuture_2](-l_completable-future_2.md) | `fun L_completableFuture_2(): Unit`<br>Wrap coroutine in LAZY completable future |
| [L_completableFuture_3](-l_completable-future_3.md) | `fun L_completableFuture_3(): Unit`<br>Wrap futures in suspension points |
| [createFuture](create-future.md) | `fun <T> createFuture(block: SuspendFunction0<T>): `[`CompletableFuture`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html)`<T>`<br>Create (and start) a future representing a coroutine |
| [delayAndPrintWorld](delay-and-print-world.md) | `suspend fun delayAndPrintWorld(): Unit`<br>Extracted fun delayAndPrintWorld |
| [getCurrentTimeString](get-current-time-string.md) | `fun getCurrentTimeString(): String`<br>Current system time as a string |
| [prepareFuture](prepare-future.md) | `fun <T> prepareFuture(block: SuspendFunction0<T>): () -> `[`CompletableFuture`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html)`<T>`<br>Prepare a future representing a coroutine |
| [suspend](suspend.md) | `suspend fun <T> `[`CompletableFuture`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/CompletableFuture.html)`<T>.suspend(): T`<br>Wrap future in suspension point |

