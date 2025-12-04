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
    fun `자동차는 전진하면 위치가 1 증가한다`() {
        // given
        val car = Car()

        // when
        val moveCar = car.move()

        // then
        val expected = 1
        val actual = moveCar.position

        assertThat(actual).isEqualTo(expected)
    }
}