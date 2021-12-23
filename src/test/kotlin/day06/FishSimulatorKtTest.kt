package day06

import assertk.assertThat
import assertk.assertions.containsExactlyInAnyOrder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FishSimulatorKtTest {
    @Test
    fun `should reduce all fish by 1 day`() {
        val input = listOf(7, 5)

        val result = simulate(input)

        assertThat(result).containsExactlyInAnyOrder(6, 4)
    }

    @Test
    fun `should reset timer to 6 and a new fish with 8 for a fish that starts with 0`() {
        val input = listOf(0)

        val result = simulate(input)

        assertThat(result).containsExactlyInAnyOrder(6, 8)
    }
}