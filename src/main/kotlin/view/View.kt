package view

import domain.Car
import domain.Cars
import domain.forEach

object View {
    private const val DELIMITER_CARS_NAME: String = ","

    fun getCarsName(): Cars {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val value: List<Car> = readln().split(DELIMITER_CARS_NAME).map { name: String -> Car(name) }
        return Cars(value)
    }

    fun getCountOfRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val count = readln().trim().toInt()
        return count
    }

    fun showGameOutput() {
        println("실행 결과")
    }

    fun showRoundResult(cars: Cars) {
        cars.forEach { car: Car ->
            println("${car.name}: ${"-".repeat(car.position)}")
        }
        println()
    }

    fun showWinners(winners: List<String>) {
        println("최종 우승자: ${winners.joinToString(", ")}")
    }
}