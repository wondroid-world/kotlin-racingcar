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
        val car = Car.from("모찌", 0)
        Assertions.assertThat(car.position).isEqualTo(position)
    }

    // 4 이상의 값이라면 자동차는 한칸 전진한다.
    @Test
    fun `자동차는 이동 전략이 true를 반환하면 전진한다`() {
        val alwaysMove = MoveStrategy { true }
        val position = Position(0)
        val car = Car.from("모찌", 0, alwaysMove)

        val moveCar = car.move()
        Assertions.assertThat(moveCar.position).isEqualTo(position + 1)
    }

    // 4 미만의 값이라면 자동차는 정지한다.
    @Test
    fun `자동차는 이동 전략이 false를 반환하면 멈춘다`() {
        val alwaysStop = MoveStrategy { false }
        val position = Position(0)
        val car = Car.from("모찌", 0, alwaysStop)

        val moveCar = car.move()
        Assertions.assertThat(moveCar.position).isEqualTo(position)
    }
}
