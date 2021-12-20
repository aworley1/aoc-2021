package day04

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val game = parseGame(input)

        val (card, number) = game.firstWinningCard()

        return card.squares.values.filterNot { it.marked }.sumOf { it.number } * number
    }

    fun part2(input: List<String>): Int {
        val game = parseGame(input)

        val (card, number) = game.lastWinningCard()

        return card.squares.values.filterNot { it.marked }.sumOf { it.number } * number
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("main/kotlin/day04/Day04_test")
    val part1TestOutput = part1(testInput)
    println(part1TestOutput)
    check(part1TestOutput == 4512)

    val input = readInput("main/kotlin/day04/Day04")
    println(part1(input))

    check(part2(testInput) == 1924)
    println(part2(input))
}
