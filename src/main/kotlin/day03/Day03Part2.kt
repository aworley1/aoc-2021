package day03

import readInput

fun main() {
    fun part2(input: List<String>): Int {
        return findOxygenGenerator(input).toInt(2) * findCO2Scrubber(input).toInt(2)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day03/Day03_test")
    val input = readInput("day03/Day03")

    println(part2(testInput))
    check(part2(testInput) == 230)
    println(part2(input))
}

private fun findOxygenGenerator(numbers: List<String>): String =
    filterDownToMatchingNumber(numbers, ::filterMostCommon)

private fun findCO2Scrubber(numbers: List<String>): String =
    filterDownToMatchingNumber(numbers, ::filterLeastCommon)

private fun filterDownToMatchingNumber(numbers: List<String>, criteria: (List<String>, Int) -> List<String>): String =
    numbers.first().foldIndexed(numbers) { index, acc, _ ->
        criteria(acc, index).ifEmpty { acc }
    }.single()

private fun filterMostCommon(numbers: List<String>, index: Int): List<String> {
    val mostCommonValue = numbers.map { it[index] }.mostCommonWithDefault('1')
    return numbers.filter { it[index] == mostCommonValue }
}

private fun List<Char>.mostCommonWithDefault(default: Char): Char {
    val countsOfElements = this.groupBy { it }.map { it.value.size }.toSet().size
    if (countsOfElements == 1) return default
    return this.groupBy { it }.maxByOrNull { it.value.size }!!.key
}

private fun filterLeastCommon(numbers: List<String>, index: Int): List<String> {
    val leastCommonValue = numbers.map { it[index] }.leastCommonWithDefault('0')
    return numbers.filter { it[index] == leastCommonValue }
}

private fun List<Char>.leastCommonWithDefault(default: Char): Char {
    val countsOfElements = this.groupBy { it }.map { it.value.size }.toSet().size
    if (countsOfElements == 1) return default
    return this.groupBy { it }.minByOrNull { it.value.size }!!.key
}