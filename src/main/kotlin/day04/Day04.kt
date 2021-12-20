package day04

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return 0
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day04/Day04_test")
    val part1TestOutput = part1(testInput)
    println(part1TestOutput)
    check(part1TestOutput == 4512)

    val input = readInput("day04/Day04")
    println(part1(input))

    check(part2(testInput) == 0)
    println(part2(input))
}
