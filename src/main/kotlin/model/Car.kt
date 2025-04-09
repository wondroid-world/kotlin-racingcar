package model

@JvmRecord
data class Car private constructor(
    val name: CarName,
    val position: Position = Position(ZERO),
    val moveStrategy: MoveStrategy = RandomMoveStrategy(),
) {
    constructor(carName: CarName) : this(carName, Position(ZERO))

    fun move(): Car =
        when {
            moveStrategy.moveable() -> this.copy(position = position + ONE_STEP)
            else -> this
        }

    companion object {
        private const val ZERO = 0
        private const val ONE_STEP = 1

        @JvmStatic
        fun from(name: String): Car = Car(CarName(name))

        fun of(
            name: String,
            position: Int,
        ): Car = Car(CarName(name), Position(position))

        fun of(
            name: String,
            position: Int,
            moveStrategy: MoveStrategy,
        ): Car = Car(CarName(name), Position(position), moveStrategy)
    }
}
