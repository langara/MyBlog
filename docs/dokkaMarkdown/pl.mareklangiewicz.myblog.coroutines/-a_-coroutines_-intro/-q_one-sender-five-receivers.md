[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [Q_oneSenderFiveReceivers](.)

# Q_oneSenderFiveReceivers

`fun Q_oneSenderFiveReceivers(): Unit`

One sender, five receivers

``` kotlin
sample {
        val sender = produceNumbersFrom(CommonPool, 1)
        for (i in 1..5)
            sender.processAll(i)
        delay(500)
//        sender.cancel()
        delay(500)
    }
```

