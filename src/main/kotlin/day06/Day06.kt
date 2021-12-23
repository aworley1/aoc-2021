package day06

import readInput

fun main() {
    fun calculate(initial: List<Int>, days: Int) = (1 until days + 1).fold(initial) { acc, i ->
        println("Day $i")
        simulate(acc)
    }

    fun calculateV2(initial: List<Int>, days: Int): Map<Int, Long> {
        val valuesFromFile = initial.groupBy { it }.mapValues { it.value.size.toLong() }
        val initialMap = (0 until 9).associateWith { (valuesFromFile[it] ?: 0) }

        return (1 until days + 1).fold(initialMap) { acc, i ->
            println("Day $i")
            simulateV2(acc)
        }
    }

    fun initial(input: List<String>) = input.single().split(",").map { it.toInt() }

    fun part1(input: List<String>): Long {
        val final = calculate(initial(input), 80)
        return final.size.toLong()
    }

    fun part2(input: List<String>): Long {
        val final = calculateV2(initial(input), 256)
        return final.sumFish()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("main/kotlin/day06/Day06_test")
    val part1TestOutput = part1(testInput)
    println("Part 1 Test: $part1TestOutput")
    check(part1TestOutput == 5934L)

    val input = readInput("main/kotlin/day06/Day06")
    println(part1(input))

    val part2TestOutput = part2(testInput)
    println("Part 2 Test: $part2TestOutput")
    check(part2TestOutput == 26984457539L)
    println(part2(input))
}

private fun Map<Int, Long>.sumFish() = values.sum()
