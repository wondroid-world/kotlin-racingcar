data class Cars(
    val value: List<Car>,
) {
    fun winners(): List<Car> {
        val maxPosition = value.maxOf { it.position }
        val winners = value.filter { it.position == maxPosition }
        return winners
    }
}