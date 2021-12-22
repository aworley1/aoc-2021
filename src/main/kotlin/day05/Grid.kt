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
        if (end.x > start.x && end.y > start.y) {
            return (start.x until end.x + 1).mapIndexed { index, _ ->
                Coord(start.x + index, start.y + index)
            }
        }

        if (start.x > end.x && start.y > end.y) {
            return (end.x until start.x + 1).mapIndexed { index, _ ->
                Coord(start.x - index, start.y - index)
            }
        }

        if (start.x > end.x && start.y < end.y) {
            return (end.x until start.x + 1).mapIndexed { index, _ ->
                Coord(start.x - index, start.y + index)
            }
        }

        if (start.x < end.x && start.y > end.y) {
            return (start.x until end.x + 1).mapIndexed { index, _ ->
                Coord(start.x + index, start.y - index)
            }
        }
        return emptyList()
    }
}

data class Coord(val x: Int, val y: Int)