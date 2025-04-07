package model

@JvmInline
value class CarName(
    val value: String,
) {
    constructor() : this("채원")

    init {
        require(value.isNotEmpty()) { "자동차 이름은 비어있을 수 없습니다." }
        require(value.length < 5) { "자동차 이름은 5글자 이내입니다." }
    }
}
