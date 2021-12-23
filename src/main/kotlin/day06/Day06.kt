package day06

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val initial = input.single().split(",").map { it.toInt() }

        val final = (1 until 81).fold(initial) { acc, _ ->
            simulate(acc)
        }

        return final.size
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("main/kotlin/day06/Day06_test")
    val part1TestOutput = part1(testInput)
    println("Part 1 Test: $part1TestOutput")
    check(part1TestOutput == 5934)

    val input = readInput("main/kotlin/day06/Day06")
    println(part1(input))

    val part2TestOutput = part2(testInput)
    println("Part 2 Test: $part2TestOutput")
    check(part2TestOutput == 0)
    println(part2(input))
}
