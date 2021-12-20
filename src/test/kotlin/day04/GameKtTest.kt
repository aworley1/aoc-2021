package day04

import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.containsExactly
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GameKtTest {
    @Test
    fun `should parse input`() {
        val result = parseGame(exampleInput.split("\n"))

        assertThat(result.numbers).containsExactly(1, 2, 3, 4, 5, 6)

        assertThat(result.cards.size).isEqualTo(2)

        println(result.cards.first())
    }

    private val exampleInput = """
        1,2,3,4,5,6
        
         0  1  2  3  4
         5  6  7  8  9
        10 11 12 13 14
        15 16 17 18 19
        20 21 22 23 24
                 
        40 41 42 43 44
        45 46 47 48 49
        50 51 52 53 54
        55 56 57 58 59
        60 61 62 63 64 
    """.trimIndent()
}