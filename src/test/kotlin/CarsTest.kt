import domain.Car
import domain.Cars
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
        val expected: List<Car> = listOf(winnerCar)
        val actual = winners

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `최대 위치가 같다면 공동 우승자가 될 수 있다`() {
        // given
        val winnerCar1 = Car("모모", 1)
        val winnerCar2 = Car("치치", 1)
        val loserCar = Car("채채", 0)
        val cars = Cars(listOf(winnerCar1, winnerCar2, loserCar))

        // when
        val winners: List<Car> = cars.winners()

        // then
        val expected: Int = listOf(winnerCar1, winnerCar2).size
        val actual = winners.size

        assertThat(actual).isEqualTo(expected)
        assertThat(winners).contains(winnerCar1, winnerCar2)
    }
}
