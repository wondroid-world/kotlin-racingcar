import domain.Position
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    fun `위치는 초기 생성시, 0이다`() {
        // given, when
        val actual = Position()

        // then
        assertThat(actual.value).isEqualTo(0)
    }

    @Test
    fun `위치는 증가할 수 있다`() {
        // given
        val position = Position()
        // when
        val newPosition = position.plus()
        // then
        assertThat(newPosition.value).isEqualTo(1)
    }
}
