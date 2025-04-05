import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class CarNameTest {
    @Test
    fun `자동차 이름은 5글자를 초과할 수 없다`() {
        assertThrows<IllegalArgumentException> {
            CarName("가나다라마")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["모찌", "토바에", "찌"])
    fun `자동차 이름은 5글자 이내여야한다`(name: String) {
        assertDoesNotThrow {
            CarName(name)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [""])
    fun `자동차 이름은 비어있을 수 없습니다`(name: String) {
        assertThrows<IllegalArgumentException> {
            CarName(name)
        }
    }
}

class CarName(
    private val name: String
) {
    init {
        require(name.isNotEmpty()) {"자동차 이름은 비어있을 수 없습니다."}
        require(name.length < 5) { "자동차 이름은 5글자 이내입니다." }
    }
}