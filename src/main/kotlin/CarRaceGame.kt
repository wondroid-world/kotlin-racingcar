import controller.CarRaceController
import view.CarRaceView

fun main() {
    val carRaceController = CarRaceController(CarRaceView())
    carRaceController.run()
}
