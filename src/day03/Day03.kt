package day03

import readInput

fun main() {
    fun findGamma(input: List<String>) =
        (0 until input[0].length).map { index ->
            input
                .map {
                    it[index]
                }
                .groupingBy { it }
                .eachCount()
                .maxByOrNull { it.value }!!.key
        }.joinToString("")
            .let { Integer.parseInt(it, 2) }

    fun findEpsilon(input: List<String>) =
        (0 until input[0].length).map { index ->
            input
                .map {
                    it[index]
                }
                .groupingBy { it }
                .eachCount()
                .minByOrNull { it.value }!!.key
        }.joinToString("")
            .let { Integer.parseInt(it, 2) }

    fun part1(input: List<String>): Int {
        return findGamma(input) * findEpsilon(input)
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day03/Day03_test")
    val part1TestOutput = part1(testInput)
    println(part1TestOutput)
    check(part1TestOutput == 198)

    val input = readInput("day03/Day03")
    println(part1(input))

    check(part2(testInput) == 230)
    println(part2(input))
}
