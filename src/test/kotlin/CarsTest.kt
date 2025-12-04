import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `2대의 자동차 중 많이 전진한 자동차가 우승자이다`() {
        // given
        val winnerCar = Car("모모", 1)
        val loserCar = Car("치치", 0)
        val cars = Cars(listOf(winnerCar, loserCar))

        // when
        val winners: List<Car> = cars.winners()

        // then
        val excepted: List<Car> = listOf(winnerCar)
        val actual = winners

        assertThat(actual).isEqualTo(excepted)
    }
}

