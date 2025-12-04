class RandomNumberGenerator : NumberGenerator {
    override fun number(): Int {
        return (RANGE_START_NUMBER .. RANGE_END_NUMBER).random()
    }

    companion object {
        private const val RANGE_START_NUMBER: Int = 0
        private const val RANGE_END_NUMBER: Int = 9
    }
}







