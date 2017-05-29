[pl.mareklangiewicz.myblog.coroutines](../index.md) / [A_Coroutines_Intro](index.md) / [mydelay](.)

# mydelay

`suspend fun mydelay(time: Long): Unit`

Simple suspending function implementation

Important: the "return" keyword (or expression body syntax) is necessary here.
Without "return" it returns from suspension more than once.. looks like bug in state machine generation

