package model

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TurnTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `턴은 음수면 게임이 진행이 안된다`(value: Int) {
        assertThrows<IllegalArgumentException> {
            Turn(value)
        }
    }
}
