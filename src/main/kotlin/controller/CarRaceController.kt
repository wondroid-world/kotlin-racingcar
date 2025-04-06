package controller

import view.CarRaceView

class CarRaceController(
    private val carRaceView: CarRaceView,
) {
    fun run() {
        val cars = carRaceView.cars()
        val turn = carRaceView.turn()
        carRaceView.showResult()
        val playedCar =
            turn.playGame(cars) { roundCars ->
                carRaceView.showGameResult(roundCars)
            }
        val winner = playedCar.winner()
        carRaceView.showWinner(winner)
    }
}
