package day06

import assertk.assertThat
import assertk.assertions.containsExactlyInAnyOrder
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class FishSimulatorKtTest {
    @Nested
    inner class v1 {
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

    @Nested
    inner class v2 {
        @Test
        fun `should reduce all fish by 1 day`() {
            val input = mapOf(
                8 to 8L,
                7 to 7L,
                6 to 6L,
                5 to 5L,
                4 to 4L,
                3 to 3L,
                2 to 2L,
                1 to 1L,
                0 to 0L
            )

            val result = simulateV2(input)

            assertThat(result[8]).isEqualTo(0)
            assertThat(result[7]).isEqualTo(8)
            assertThat(result[6]).isEqualTo(7)
            assertThat(result[5]).isEqualTo(6)
            assertThat(result[4]).isEqualTo(5)
            assertThat(result[3]).isEqualTo(4)
            assertThat(result[2]).isEqualTo(3)
            assertThat(result[1]).isEqualTo(2)
            assertThat(result[0]).isEqualTo(1)
        }

        @Test
        fun `should reset timer to 6 and a new fish with 8 for a fish that starts with 0`() {
            val input = mapOf(
                8 to 0L,
                7 to 1L,
                6 to 0L,
                5 to 0L,
                4 to 0L,
                3 to 0L,
                2 to 0L,
                1 to 0L,
                0 to 1L
            )

            val result = simulateV2(input)

            assertThat(result[8]).isEqualTo(1)
            assertThat(result[7]).isEqualTo(0)
            assertThat(result[6]).isEqualTo(2)
            assertThat(result[5]).isEqualTo(0)
            assertThat(result[4]).isEqualTo(0)
            assertThat(result[3]).isEqualTo(0)
            assertThat(result[2]).isEqualTo(0)
            assertThat(result[1]).isEqualTo(0)
            assertThat(result[0]).isEqualTo(0)
        }
    }
}