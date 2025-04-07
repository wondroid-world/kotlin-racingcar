package model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차는 이름을 가진다`() {
        val carName = CarName("모찌")
        val car = Car(carName)
        Assertions.assertThat(car.name).isEqualTo(carName)
    }

    @Test
    fun `자동차는 위치를 가진다`() {
        val carName = CarName("모찌")
        val position = Position(0)
        val car = Car(carName, position)
        Assertions.assertThat(car.position).isEqualTo(position)
    }

    // 4 이상의 값이라면 자동차는 한칸 전진한다.
    @Test
    fun `자동차는 랜덤 숫자가 4이상이면 전진한다`() {
        val carName = CarName("모찌")
        val position = Position(0)
        val car = Car(carName, position)
        val acceleratorNumber = 4

        val moveCar = car.move(acceleratorNumber)
        Assertions.assertThat(moveCar.position).isEqualTo(position + 1)
    }

    // 4 미만의 값이라면 자동차는 정지한다.
    @Test
    fun `자동차는 랜덤 숫자가 4미만이면 멈춘다`() {
        val carName = CarName("모찌")
        val position = Position(0)
        val car = Car(carName, position)
        val acceleratorNumber = 3

        val moveCar = car.move(acceleratorNumber)
        Assertions.assertThat(moveCar.position).isEqualTo(position)
    }
}
