import domain.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class CarTest {
    @Test
    fun `자동차 생성할 때, 이름이 있어야한다`() {
        // given
        val carName = "모찌"

        // then
        assertDoesNotThrow { Car(carName) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["모", "모모", "모치치", "모모치치", "모모와치치"])
    fun `자동차 이름에 1~5자 사이의 String 타입 글자를 넣어도 자동차가 생성이 된다`(name: String) {
        // then
        assertDoesNotThrow { Car(value = name) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["모모치치채채"])
    fun `자동차 이름에 6자 이상의 String 타입 글자를 넣으면 자동차가 생성되지 않는다`(name: String) {
        // then
        assertThrows<IllegalArgumentException> { Car(value = name) }
    }

    @Test
    fun `자동차 초기 위치는 0이다`() {
        // given, when
        val carName = "모찌"
        val car = Car(carName)

        // then
        val expected = 0
        val actual = car.position

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `자동차는 전진 조건에 만족하면, 위치가 1 증가한다`() {
        // given
        val carName = "모찌"
        val car = Car(carName)
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
        val carName = "모찌"
        val car = Car(carName)
        val canMove = false

        // when
        val moveCar: Car = car.move(canMove)

        // then
        val expected = 0
        val actual: Int = moveCar.position

        assertThat(actual).isEqualTo(expected)
    }
}
