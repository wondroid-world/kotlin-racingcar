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

    @Test
    fun `자동차는 전진한다`() {
        val carName = CarName("모찌")
        val position = Position(0)
        val car = Car(carName, position)

        val moveCar = car.move()
        Assertions.assertThat(moveCar.position).isEqualTo(position + 1)
    }
}

class Car(
    val name: CarName,
    val position: Position = Position(0),
) {
    constructor(carName: CarName) : this(carName, Position(0))

    fun move(): Car = Car(this.name, this.position + 1)
}

// 나는 왜 불변객체로 만들고 싶은가
// 불변 객체의 이점
// class와 data class의 차이
