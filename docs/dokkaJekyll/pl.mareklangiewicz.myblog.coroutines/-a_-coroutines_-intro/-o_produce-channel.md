---
title: A_Coroutines_Intro.O_produceChannel - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [O_produceChannel](.)

# O_produceChannel

`fun O_produceChannel(): Unit`

Use `produce` utility function

``` kotlin
"main: start".p
val channel = produce(CommonPool) {
    for (i in 1..10) {
        "produce: sending: $i".p
        send(i)
    }
}
launch(CommonPool) {
    for (i in channel)
        "received: $i".p
}
Thread.sleep(2000)
"main: end".p
```

