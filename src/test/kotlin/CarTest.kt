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
}

class Car(
    val name: CarName,
    val position: Position = Position(0),
) {
    constructor(carName: CarName) : this(carName, Position(0))
}
