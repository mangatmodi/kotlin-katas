import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

internal class StringSortTest {

    @Test
    @DisplayName("String sorting")
    fun sort() {
        listOf(
            "Sorting123" to "ginortS213",
            "" to "",
            "HelloWorld" to "dellloorHW"
        ).forEach { assertEquals(it.second, sort(it.first)) }
    }
}