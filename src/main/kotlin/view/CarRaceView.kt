package view

import model.Car
import model.Cars
import model.Turn

class CarRaceView {
    fun cars(): Cars {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val cars = readln().split(",").map { Car.from(it.trim()) }
        return Cars.from(cars)
    }

    fun turn(): Turn {
        println("시도할 횟수는 몇 회인가요?")
        val turn = Turn(readln().trim().toInt())
        return turn
    }

    fun showResult() {
        println("\n실행 결과")
    }

    fun showGameResult(cars: Cars) {
        cars.forEach {
            println("${it.name.value} : ${"-".repeat(it.position.value)}")
        }
        println()
    }

    fun showWinner(winner: List<Car>) {
        println("최종 우승자: ${winner.map { it.name.value }.joinToString()}")
    }
}
