package $DAY_DIR

import readInput

fun main() {
    fun part1(input: List<String>): Long {
        return 0
    }

    fun part2(input: List<String>): Long {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("main/kotlin/${DAY_DIR}/${DAY_NAME}_test")
    val part1TestOutput = part1(testInput)
    println("Part 1 Test: $part1TestOutput")
    check(part1TestOutput == 0L)

    val input = readInput("main/kotlin/${DAY_DIR}/${DAY_NAME}_test")
    println(part1(input))

    val part2TestOutput = part2(testInput)
    println("Part 2 Test: $part2TestOutput")
    check(part2TestOutput == 0L)
    println(part2(input))
}
