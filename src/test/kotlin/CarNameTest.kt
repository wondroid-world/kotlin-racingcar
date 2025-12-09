import domain.CarName
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = ["모", "모모", "모치치", "모모치치", "모모와치치"])
    fun `자동차의_이름은_1자에서_5자_사이이다`(value: String) {
        assertDoesNotThrow { CarName(value) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["모모치치채채"])
    fun `자동차의_이름은_6자_이상이면_에러가_난다`(value: String) {
        assertThrows<IllegalArgumentException> { CarName(value) }
    }
}
