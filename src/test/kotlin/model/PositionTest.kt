package model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositionTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, -1000])
    fun `이동거리는 음수일 수 없다`(value: Int) {
        assertThrows<IllegalArgumentException> {
            Position(value)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 1000])
    fun `이동거리는 0이거나 양수이다`(value: Int) {
        val position = Position(value)
        Assertions.assertThat(position.value).isEqualTo(value)
    }
}
