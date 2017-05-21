---
title: A_Coroutines_Intro.B_runBlocking - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [B_runBlocking](.)

# B_runBlocking

`fun B_runBlocking(): Unit`

``` kotlin
runBlocking {
    delay(1000)
    println("1000")
    delay(1000)
    println("2000")
    delay(1000)
    println("3000")
}
```

