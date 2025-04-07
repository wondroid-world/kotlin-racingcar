package model

import java.util.Random

class RandomMoveStrategy : MoveStrategy {
    override fun moveable(): Boolean {
        val randomNumber = Random().nextInt(1, 9)
        return when {
            randomNumber >= 4 -> true
            else -> false
        }
    }
}
