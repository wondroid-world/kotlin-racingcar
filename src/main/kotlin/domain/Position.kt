package domain

@JvmInline
value class Position(
    val value: Int = 0,
) {
    fun plus(): Position = Position(value + 1)
}