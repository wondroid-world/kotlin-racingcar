package model

@JvmRecord
data class Car private constructor(
    val name: CarName,
    val position: Position = Position(ZERO),
) {
    constructor(carName: CarName) : this(carName, Position(ZERO))

    fun move(acceleratorNumber: Int): Car {
        if (acceleratorNumber >= MOVE_ACCELERATOR_NUMBER) return this.copy(position = position + ONE_STEP)
        return this
    }

    companion object {
        private const val ZERO = 0
        private const val MOVE_ACCELERATOR_NUMBER = 4
        private const val ONE_STEP = 1

        fun from(name: String): Car = Car(CarName(name))

        fun from(
            name: String,
            position: Int,
        ): Car = Car(CarName(name), Position(position))
    }
}

// 나는 왜 불변객체로 만들고 싶은가
// 불변 객체의 이점
// class와 data class의 차이
