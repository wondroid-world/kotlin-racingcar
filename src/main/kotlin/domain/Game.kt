package domain

class Game(
    private val moveStrategy: MoveStrategy,
    private val readyCars: Cars
) {
    val cars: Cars get() = _cars
    private var _cars: Cars = readyCars

    private fun playRound(): Cars {
        return _cars.move(moveStrategy)
    }

    fun playRounds(countOfRound: Int) {
        repeat(countOfRound) {
            val movedCars = playRound()
            _cars = movedCars
        }
    }

    fun winners(): List<Car> {
        return _cars.winners()
    }
}