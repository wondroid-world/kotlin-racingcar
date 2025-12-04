data class Car(
    val position: Int = 0
) {
    fun move(): Car {
        val newPosition = position + 1
        return Car(newPosition)
    }
}