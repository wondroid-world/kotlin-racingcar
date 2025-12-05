class NumberMoveStrategy(
    private val numberGenerator: NumberGenerator,
) : MoveStrategy {
    override fun canMove(): Boolean {
        val number = numberGenerator.number()
        return number >= STANDARD_NUMBER_FOR_MOVE
    }

    companion object {
        private const val STANDARD_NUMBER_FOR_MOVE = 4
    }
}