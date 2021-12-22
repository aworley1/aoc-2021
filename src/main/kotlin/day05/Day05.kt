package day05

import day04.Card
import day04.parseGame
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val grid = Grid.parse(input)
        val allPoints = grid.allPoints()
        return allPoints.groupBy { it }.filter { it.value.size > 1 }.size
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("main/kotlin/day05/Day05_test")
    val part1TestOutput = part1(testInput)
    println("Part 1 Test: $part1TestOutput")
    check(part1TestOutput == 5)

    val input = readInput("main/kotlin/day05/Day05")
    println(part1(input))

    check(part2(testInput) == 1924)
    println(part2(input))
}
