data class Car(
    val name: CarName,
    val position: Int = 0
) {

    fun move(canMove: Boolean): Car {
        val newPosition = if (canMove) position + 1 else position
        return Car(name, newPosition)
    }

    companion object {
        operator fun invoke(value: String, position: Int = 0): Car {
            val carName = CarName(value)
            return Car(carName, position)
        }
    }
}