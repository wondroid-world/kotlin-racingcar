class InputView {
    fun getCarsName(): Cars {
        val value: List<Car> = readln().split(DELIMITER_CARS_NAME).map { name: String -> Car(name) }
        return Cars(value)
    }

    companion object {
        private const val DELIMITER_CARS_NAME: String = ","
    }
}