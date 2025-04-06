@file:JvmName("RandomNumber")

package util

import java.util.Random

fun randomNumber(): Int = Random().nextInt(1, 9)
