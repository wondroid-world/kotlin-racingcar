package domain

data class Car(
    private val _name: CarName,
    private val _position: Position,
) {
    val name: String = _name.value
    val position: Int = _position.value

    fun move(canMove: Boolean): Car {
        val newPosition = if (canMove) _position.plus() else _position
        return Car(_name, newPosition)
    }

    companion object {
        operator fun invoke(
            value: String,
            position: Int = 0,
        ): Car {
            val carName = CarName(value)
            val carPosition = Position(position)
            return Car(carName, carPosition)
        }
    }
}
