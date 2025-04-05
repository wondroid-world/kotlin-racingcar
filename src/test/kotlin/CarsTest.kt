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
}

class Cars(
    val value: Set<Car>,
) {
    companion object {
        fun from(cars: List<Car>): Cars {
            if (cars.size == cars.toSet().size) {
                return Cars(cars.toSet())
            }
            throw IllegalArgumentException("동일한 이름의 차가 들어왔습니다. 다른 이름을 입력해주세요.")
        }
    }
}

// 여기서 list가 아니라 Set을 쓰고 싶은 이유?
// factory 메서드랑 생성자로 만드는 건 뭐가 다른건가?
// 동반객체가 뭘까?
// position.value를 들어가지 않고 비교하는 방법은 없나?
// companion object 안에 좀더 코틀린 스럽게 쓰는 방법 생각해보기
