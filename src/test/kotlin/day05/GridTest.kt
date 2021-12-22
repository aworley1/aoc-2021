package day05

import assertk.assertThat
import assertk.assertions.containsExactlyInAnyOrder
import org.junit.jupiter.api.Test

internal class GridTest {
    @Test
    fun `should parse input ignoring diagonals`() {
        val input = listOf(
            "0,9 -> 5,9",
            "8,0 -> 0,8",
            "2,2 -> 2,1"
        )

        val result = Grid.parse(input)

        assertThat(result.lines).containsExactlyInAnyOrder(
            Line(Coord(0, 9), Coord(5, 9)),
            Line(Coord(2, 2), Coord(2, 1)),
            Line(Coord(8, 0), Coord(0, 8)),
        )
    }

    @Test
    fun `should find all points on a horizontal line`() {
        val line = Line(
            start = Coord(3, 0),
            end = Coord(0, 0)
        )

        val result = line.allPointsExcDiag()

        assertThat(result).containsExactlyInAnyOrder(
            Coord(0, 0),
            Coord(1, 0),
            Coord(2, 0),
            Coord(3, 0),
        )
    }

    @Test
    fun `should find all points on a vertical line`() {
        val line = Line(
            start = Coord(0, 3),
            end = Coord(0, 0)
        )

        val result = line.allPointsExcDiag()

        assertThat(result).containsExactlyInAnyOrder(
            Coord(0, 0),
            Coord(0, 1),
            Coord(0, 2),
            Coord(0, 3),
        )
    }

    @Test
    fun `should find all points on a diagonal line - 1`() {
        val line = Line(
            start = Coord(1, 1),
            end = Coord(3, 3)
        )

        val result = line.allPoints()

        assertThat(result).containsExactlyInAnyOrder(
            Coord(1,1),
            Coord(2,2),
            Coord(3,3),
        )
    }

    @Test
    fun `should find all points on a diagonal line - 2`() {
        val line = Line(
            start = Coord(3,3),
            end = Coord(1,1)
        )

        val result = line.allPoints()

        assertThat(result).containsExactlyInAnyOrder(
            Coord(1,1),
            Coord(2,2),
            Coord(3,3),
        )
    }

    @Test
    fun `should find all points on a diagonal line - 3`() {
        val line = Line(
            start = Coord(9,7),
            end = Coord(7,9)
        )

        val result = line.allPoints()

        assertThat(result).containsExactlyInAnyOrder(
            Coord(9,7),
            Coord(8,8),
            Coord(7,9),
        )
    }

    @Test
    fun `should find all points on a diagonal line - 4`() {
        val line = Line(
            start = Coord(7,9),
            end = Coord(9,7)
        )

        val result = line.allPoints()

        assertThat(result).containsExactlyInAnyOrder(
            Coord(9,7),
            Coord(8,8),
            Coord(7,9),
        )
    }
}