import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsTest {
    @Test
    fun `자동차 여러대가 있다`() {
        val car1 = Car.from("모찌")
        val car2 = Car.from("치치")
        val car3 = Car.from("모모")
        val cars = Cars.from(listOf(car1, car2, car3))

        Assertions.assertThat(cars.value.isNotEmpty()).isTrue()
    }

    @Test
    fun `동일한 이름의 차가 들어오면 게임이 진행이 안된다`() {
        val car1 = Car.from("모찌")
        val car2 = Car.from("모모")
        val car3 = Car.from("모모")

        assertThrows<IllegalArgumentException> {
            Cars.from(listOf(car1, car2, car3))
        }
    }

    @Test
    fun `가장 많이 이동한 차를 구한다`() {
        val car1 = Car.from("모찌", 3)
        val car2 = Car.from("치치", 1)
        val car3 = Car.from("모모", 1)

        val cars = Cars.from(listOf(car1, car2, car3))

        val result = cars.winner()

        Assertions.assertThat(result).isEqualTo(listOf(car1))
    }

    @Test
    fun `가장 많이 이동한 차들을 구한다`() {
        val car1 = Car.from("모찌", 3)
        val car2 = Car.from("치치", 3)
        val car3 = Car.from("모모", 1)

        val cars = Cars.from(listOf(car1, car2, car3))

        val result = cars.winner()

        Assertions.assertThat(result).isEqualTo(listOf(car1, car2))
    }
}
