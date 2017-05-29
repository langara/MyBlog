---
title: A_Coroutines_Intro.M_rxSubscriber - 
---

[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [M_rxSubscriber](.)

# M_rxSubscriber

`fun M_rxSubscriber(): Unit`

Implement rx subscriber wrapping coroutine block

``` kotlin
        val flowable = Flowable
                .interval(300, TimeUnit.MILLISECONDS)
                .take(10)
        val subscriber = RxSubscriber<Long> {
            receive().p
//            close()
            receive().p
            receive().p
//            delay(1500)
            receive().p
            receive().p
            receive().p
        }
        flowable.subscribe(subscriber)
        Thread.sleep(10000)
```

