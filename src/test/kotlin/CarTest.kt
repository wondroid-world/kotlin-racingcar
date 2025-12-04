import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 초기 위치는 0이다`() {
        // given, when
        val car = Car()

        // then
        val expected = 0
        val actual = car.position

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `자동차는 전진 조건에 만족하면, 위치가 1 증가한다`() {
        // given
        val car = Car()
        val canMove = true

        // when
        val moveCar: Car = car.move(canMove)

        // then
        val expected = 1
        val actual: Int = moveCar.position

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `자동차는 전진 조건에 만족하지 않으면, 위치는 그대로이다`() {
        // given
        val car = Car()
        val canMove = false

        // when
        val moveCar: Car = car.move(canMove)

        // then
        val expected = 0
        val actual: Int = moveCar.position

        assertThat(actual).isEqualTo(expected)
    }
}

