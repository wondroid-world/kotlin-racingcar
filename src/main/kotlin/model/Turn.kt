package model

@JvmInline
value class Turn(
    private val value: Int,
) {
    init {
        require(value > 0) { "턴은 양수만 가능합니다." }
    }
}
