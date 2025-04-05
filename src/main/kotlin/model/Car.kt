package model

data class Car(
    val name: CarName,
    val position: Position = Position(0),
) {
    constructor(carName: CarName) : this(carName, Position(0))

    fun move(acceleratorNumber: Int): Car {
        if (acceleratorNumber >= 4) return Car(this.name, this.position + 1)
        return this
    }

    companion object {
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
