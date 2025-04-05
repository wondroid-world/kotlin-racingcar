@JvmInline
value class CarName(
    private val name: String,
) {
    constructor() : this("채원")

    init {
        require(name.isNotEmpty()) { "자동차 이름은 비어있을 수 없습니다." }
        require(name.length < 5) { "자동차 이름은 5글자 이내입니다." }
    }
}

// 의문1
// 나는 왜 여기서 class가 아니라 value class를 사용할려고 했는가
// -> 타입의 안정성
// isNotEmpty와 1보다 크다는 동일하지 않는가
// 동일한의미임
// value class는 부생성자를 못씀?
