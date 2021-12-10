package day02

import readInput

private data class Position(val depth: Int, val horizontal: Int) {
    fun apply(input: String): Position {
        val command = input.split(" ")[0]
        val amount = input.split(" ")[1].toInt()

        return when (command) {
            "up" -> copy(depth = depth - amount)
            "down" -> copy(depth = depth + amount)
            "forward" -> copy(horizontal = horizontal + amount)
            else -> throw RuntimeException()
        }
    }
}

private data class Position2(val depth: Int, val horizontal: Int, val aim: Int) {
    fun apply(input: String): Position2 {
        val command = input.split(" ")[0]
        val amount = input.split(" ")[1].toInt()

        return when (command) {
            "up" -> copy(aim = aim - amount)
            "down" -> copy(aim = aim + amount)
            "forward" -> copy(horizontal = horizontal + amount, depth = depth + (aim * amount))
            else -> throw RuntimeException()
        }
    }
}

fun main() {
    fun part1(input: List<String>): Int {
        val position = input.fold(Position(0, 0)) { acc, command ->
            acc.apply(command)
        }
        return position.depth * position.horizontal
    }

    fun part2(input: List<String>): Int {
        val position = input.fold(Position2(0, 0, 0)) { acc, command ->
            acc.apply(command)
        }
        return position.depth * position.horizontal
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day02/Day02_test")
    val part1TestOutput = part1(testInput)
    println(part1TestOutput)
    check(part1TestOutput == 150)

    val input = readInput("day02/Day02")
    println(part1(input))

    check(part2(testInput) == 900)
    println(part2(input))
}
