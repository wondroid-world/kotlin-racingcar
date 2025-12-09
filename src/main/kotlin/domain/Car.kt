package domain

data class Car(
    private val _name: CarName,
    val position: Int = 0,
) {
    val name: String = _name.value

    fun move(canMove: Boolean): Car {
        val newPosition = if (canMove) position + 1 else position
        return Car(_name, newPosition)
    }

    companion object {
        operator fun invoke(
            value: String,
            position: Int = 0,
        ): Car {
            val carName = CarName(value)
            return Car(carName, position)
        }
    }
}
