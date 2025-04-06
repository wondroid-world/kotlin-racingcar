package model

@JvmInline
value class Turn(
    val value: Int,
) {
    init {
        require(value > 0) { "턴은 양수만 가능합니다." }
    }

    fun playGame(cars: Cars): Cars {
        var newCars: Cars = cars
        repeat(value) {
            newCars = cars.play()
        }
        return newCars
    }
}
