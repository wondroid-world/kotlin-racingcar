data class Car(
    val position: Int = 0
) {
    fun move(canMove: Boolean): Car {
        val newPosition = if (canMove) position + 1 else position
        return Car(newPosition)
    }
}