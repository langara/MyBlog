[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [filter](.)

# filter

`fun <T> ReceiveChannel<T>.filter(context: CoroutineContext, predicate: SuspendFunction1<T, Boolean>): ProducerJob<T>`

Simple filter implementation for channels

