@JvmInline
value class Position(
    val value: Int,
) {
    init {
        require(value >= 0) { "이동 거리는 음수일 수 없습니다." }
    }
}
