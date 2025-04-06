package model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TurnTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `턴은 음수면 게임이 진행이 안된다`(value: Int) {
        assertThrows<IllegalArgumentException> {
            Turn(value)
        }
    }

    @Test
    fun `턴만큼 게임을 자동차 경주를 진행하면, 자동차의 상태가 바뀐다`() {
        val car1 = Car.from("모찌")
        val car2 = Car.from("치치")
        val car3 = Car.from("모모")

        val cars = Cars.from(listOf(car1, car2, car3))

        val turn = Turn(5)
        val playedCars = turn.playGame(cars)

        Assertions.assertThat(cars != playedCars).isTrue()
    }
}
