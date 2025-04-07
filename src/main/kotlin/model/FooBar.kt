package model

class FooBar {
    val foo = 123
    val bar1 = foo
    val bar2 get() = foo
}
