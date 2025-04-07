package model

@JvmInline
value class Position(
    val value: Int,
) {
    init {
        require(value >= ZERO) { POSITION_NOT_NEGATIVE_NUMBER }
    }

    operator fun plus(i: Int): Position = Position(this.value + 1)

    companion object {
        private const val ZERO = 0
        private const val POSITION_NOT_NEGATIVE_NUMBER = "이동 거리는 음수일 수 없습니다."
    }
}
