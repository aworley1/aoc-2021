package day07

import readInput
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Long {
        val crabs = input.single().split(",").map { it.toInt() }

        return crabs.mapIndexed { index, element ->
            val otherCrabs = crabs.slice(0 until index) + crabs.slice(index + 1 until crabs.size)
            otherCrabs.sumOf { abs(it - element) }
        }.minOf { it }.toLong()
    }

    fun part2(input: List<String>): Long {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("main/kotlin/day07/Day07_test")
    val part1TestOutput = part1(testInput)
    println("Part 1 Test: $part1TestOutput")
    check(part1TestOutput == 37L)

    val input = readInput("main/kotlin/day07/Day07")
    println(part1(input))

    val part2TestOutput = part2(testInput)
    println("Part 2 Test: $part2TestOutput")
    check(part2TestOutput == 0L)
    println(part2(input))
}
