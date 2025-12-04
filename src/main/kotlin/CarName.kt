@JvmInline
value class CarName(
    private val value: String,
) {
    init {
        require(value.length in 1..5) { "자동차의 이름은 1자에서 5자 사이입니다." }
    }
}
