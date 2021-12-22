package day04

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val game = parseGame(input)

        var currentCards = game.cards

        game.numbers.forEach { number ->
            currentCards = currentCards.map { it.mark(number) }
            currentCards.singleOrNull { it.hasWon() }?.let { return it.score(number) }
        }

        throw RuntimeException("No numbers :(")
    }

    fun part2(input: List<String>): Int {
        val game = parseGame(input)

        var previousCards = game.cards
        lateinit var currentCards: List<Card>

        game.numbers.forEachIndexed { index, number ->
            currentCards = previousCards.map { it.mark(number) }
            if (currentCards.all { it.hasWon() }) return previousCards.single { !it.hasWon() }.score(game.numbers[index - 1])
            previousCards = currentCards
        }

        throw RuntimeException("No numbers :(")
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
