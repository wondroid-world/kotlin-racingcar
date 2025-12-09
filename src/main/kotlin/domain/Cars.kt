package domain

data class Cars(
    private val value: List<Car>,
) {
    fun move(moveStrategy: MoveStrategy): Cars {
        val moved = value.map { it.move(moveStrategy.canMove()) }
        return Cars(moved)
    }

    fun winners(): List<Car> {
        val maxPosition = value.maxOf { it.position }
        val winners = value.filter { it.position == maxPosition }
        return winners
    }
}