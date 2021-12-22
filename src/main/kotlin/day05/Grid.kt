package day05

data class Grid(val lines: List<Line>) {
    fun allPointsExcDiag() = lines.flatMap { it.allPointsExcDiag() }
    fun allPoints() = lines.flatMap { it.allPoints() }

    companion object {
        fun parse(input: List<String>): Grid {
            val regex = "(\\d+),(\\d+) -> (\\d+),(\\d+)".toRegex()
            return input.map {
                val matches = regex.find(it)!!.groupValues
                Line(
                    start = Coord(matches[1].toInt(), matches[2].toInt()),
                    end = Coord(matches[3].toInt(), matches[4].toInt()),
                )
            }.let { Grid(it) }
        }
    }
}

data class Line(val start: Coord, val end: Coord) {
    private fun isHorizontal() = start.y == end.y
    private fun isVertical() = start.x == end.x

    fun allPoints(): List<Coord> {
        return when {
            isHorizontal() || isVertical() -> allPointsExcDiag()
            else -> findDiagPoints()
        }
    }

    fun allPointsExcDiag(): List<Coord> {
        return when {
            isHorizontal() -> {
                val startX = minOf(start.x, end.x)
                val endX = maxOf(start.x, end.x)
                (startX until endX + 1).map {
                    Coord(it, start.y)
                }
            }
            isVertical() -> {
                val startY = minOf(start.y, end.y)
                val endY = maxOf(start.y, end.y)
                (startY until endY + 1).map {
                    Coord(start.x, it)
                }
            }
            else -> emptyList()
        }
    }

    private fun findDiagPoints(): List<Coord> {
        val startCoord = listOf(start, end).minByOrNull { it.x }!!
        val endCoord = listOf(start, end).maxByOrNull { it.x }!!

        if (startCoord.y < endCoord.y) {
            return (startCoord.x until endCoord.x + 1).mapIndexed { index, _ ->
                Coord(startCoord.x + index, startCoord.y + index)
            }
        }

        if (startCoord.y > endCoord.y) {
            return (startCoord.x until endCoord.x + 1).mapIndexed { index, _ ->
                Coord(startCoord.x + index, startCoord.y - index)
            }
        }

        return emptyList()
    }
}

data class Coord(val x: Int, val y: Int)