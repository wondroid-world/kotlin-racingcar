package controller

import domain.Cars
import domain.Game
import domain.NumberMoveStrategy
import domain.RandomNumberGenerator
import view.View

class RacingGame {
    fun play() {
        val moveStrategy = gameStrategy()
        val cars = View.getCarsName()
        val count = View.getCountOfRound()
        View.showGameOutput()
        val game = playGame(moveStrategy, cars, count)
        getWinner(game)
    }

    private fun gameStrategy(): NumberMoveStrategy {
        val randomNumberGenerator = RandomNumberGenerator()
        val moveStrategy = NumberMoveStrategy(randomNumberGenerator)
        return moveStrategy
    }

    private fun playGame(
        moveStrategy: NumberMoveStrategy,
        cars: Cars,
        count: Int,
    ): Game {
        val game = Game(moveStrategy, cars)
        repeat(count) {
            game.playRound()
            View.showRoundResult(game.cars)
        }
        return game
    }

    private fun getWinner(game: Game) {
        val winner: List<String> = game.winners().map { it.name }
        View.showWinners(winner)
    }
}
