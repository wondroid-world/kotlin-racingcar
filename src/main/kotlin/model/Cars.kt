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
