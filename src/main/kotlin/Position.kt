@JvmInline
value class Position(
    val value: Int,
) {
    operator fun plus(i: Int): Position = Position(this.value + 1)

    init {
        require(value >= 0) { "이동 거리는 음수일 수 없습니다." }
    }
}
