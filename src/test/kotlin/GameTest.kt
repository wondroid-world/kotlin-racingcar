import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun `라운드를 진행하면 자동차들의 위치가 변한다`() {
        // given
        val car1 = Car("모모", 1)
        val car2 = Car("치치", 1)
        val car3 = Car("채채", 0)
        val readyCars = Cars(listOf(car1, car2, car3))
        val numberMoveStrategy = NumberMoveStrategy(NumberGenerator { 4 })
        val game = Game(numberMoveStrategy, readyCars)
        val countOfRound = 3

        // when
        game.playRounds(countOfRound)

        // then
        assertThat(game.cars).isNotEqualTo(readyCars)
    }
}