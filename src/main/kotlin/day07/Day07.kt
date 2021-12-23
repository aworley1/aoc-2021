package day07

import readInput
import kotlin.math.abs

fun main() {
    fun getCrabs(input: List<String>) = input.single().split(",").map { it.toInt() }

    fun part1(input: List<String>): Long {
        val crabs = getCrabs(input)

        return crabs.mapIndexed { index, element ->
            val otherCrabs = crabs.slice(0 until index) + crabs.slice(index + 1 until crabs.size)
            otherCrabs.sumOf { abs(it - element) }
        }.minOf { it }.toLong()
    }

    fun part2(input: List<String>): Long {
        val crabs = getCrabs(input)

        return crabs.mapIndexed { index, element ->
            val otherCrabs = crabs.slice(0 until index) + crabs.slice(index + 1 until crabs.size)
            otherCrabs.sumOf { calculateFuel( abs(it - element).toLong()) }
        }.also { println(it) }.minOf { it }.toLong()
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
    check(part2TestOutput == 170L)
    println(part2(input))
}

private fun calculateFuel(move: Long): Long {
    return (1..move).sumOf { it }
}
