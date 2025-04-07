package model

@JvmInline
value class Turn(
    private val value: Int,
) {
    init {
        require(value > ZERO) { TURN_POSITIVE_NUMBER_ONLY }
    }

    fun playGame(
        cars: Cars,
        oneRoundEnd: (Cars) -> Unit,
    ): Cars {
        var newCars: Cars = cars
        repeat(value) {
            newCars = newCars.play()
            oneRoundEnd(newCars)
        }
        return newCars
    }

    companion object {
        private const val ZERO = 0
        private const val TURN_POSITIVE_NUMBER_ONLY = "턴은 양수만 가능합니다."
    }
}
