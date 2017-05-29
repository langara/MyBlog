---
title: A_Coroutines_Intro.fibonacci - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [fibonacci](.)

# fibonacci

`suspend fun fibonacci(n: Int, c: SendChannel<Int>): Unit`

Fibonacci numbers generator

Sends given number of Fibonacci numbers to given [SendChannel](#)

