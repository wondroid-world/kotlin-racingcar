package domain

class Game(
    private val moveStrategy: MoveStrategy,
    private val readyCars: Cars
) {
    val cars: Cars get() = _cars
    private var _cars: Cars = readyCars

    fun playRound() {
        val movedCars = _cars.move(moveStrategy)
        _cars = movedCars
    }

    fun winners(): List<Car> {
        return _cars.winners()
    }
}