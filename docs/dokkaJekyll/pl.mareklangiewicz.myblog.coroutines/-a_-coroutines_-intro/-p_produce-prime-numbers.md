---
title: A_Coroutines_Intro.P_producePrimeNumbers - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [P_producePrimeNumbers](.)

# P_producePrimeNumbers

`fun P_producePrimeNumbers(): Unit`

Generate prime numbers with crazy channels pipeline

``` kotlin
sample {
        var cur = produceNumbersFrom(CommonPool, 2)
        for (i in 1..20) {
            val prime = cur.receive()
            "prime: $prime".p
            cur = cur.filter(context) { it % prime != 0 }
        }
    }
```

