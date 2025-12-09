import domain.NumberGenerator
import domain.NumberMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberMoveStrategyTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `숫자가 4이상이면, 전진할 수 있다`(value: Int) {
        // given
        val numberGenerator = NumberGenerator { value }
        val numberMoveStrategy = NumberMoveStrategy(numberGenerator)

        // when, then
        val actual = numberMoveStrategy.canMove()

        assertThat(actual).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `숫자가 3이하이면, 전진할 수 없다`(value: Int) {
        // given
        val numberGenerator = NumberGenerator { value }
        val numberMoveStrategy = NumberMoveStrategy(numberGenerator)

        // when, then
        val actual = numberMoveStrategy.canMove()

        assertThat(actual).isFalse()
    }
}