package model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class StringTest {
    @Test
    fun `공백인지 확인`() {
        Assertions.assertThat(" ".isNotEmpty()).isTrue()
        Assertions.assertThat(" ".isBlank()).isTrue()
        Assertions.assertThat("r".isNotBlank()).isTrue()
    }
}
