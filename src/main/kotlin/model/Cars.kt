package model

import util.randomNumber

class Cars private constructor(
    val value: Set<Car>,
) {
    fun winner(): List<Car> {
        val maxPosition = this.value.maxOf { it.position.value }
        val winners = this.value.filter { it.position.value == maxPosition }
        return winners
    }

    fun play(): Cars {
        val cars =
            value.map { car: Car ->
                car.move(randomNumber())
            }
        return Cars(cars.toSet())
    }

    fun forEach(action: (Car) -> Unit) = value.forEach { car -> action(car) }

    companion object {
        private const val SAME_CAR_NAME = "동일한 이름의 차가 들어왔습니다. 다른 이름을 입력해주세요."

        fun from(cars: List<Car>): Cars {
            // 이름을 기준으로 동일한지 체크
            require(cars.size == cars.map { it.name }.toSet().size) {
                SAME_CAR_NAME
            }
            return Cars(cars.toSet())
        }
    }
}

// 여기서 list가 아니라 Set을 쓰고 싶은 이유?
// factory 메서드랑 생성자로 만드는 건 뭐가 다른건가?
// 동반객체가 뭘까?
// position.value를 들어가지 않고 비교하는 방법은 없나?
// companion object 안에 좀더 코틀린 스럽게 쓰는 방법 생각해보기
