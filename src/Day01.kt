fun main() {
    fun part1(input: List<String>): Int {
        return input.windowed(2)
            .map {
                if (it[1].toInt() > it[0].toInt()) 1 else 0
            }.sum()
    }

    fun part2(input: List<String>): Int {
        return input.map { it.toInt() }
            .windowed(3)
            .windowed(2)
            .map {
                if (it[1].sum() > it[0].sum()) 1 else 0
            }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    val part1TestOutput = part1(testInput)
    println(part1TestOutput)
    check(part1TestOutput == 7)

    val input = readInput("Day01")
    println(part1(input))

    check(part2(testInput) == 5)
    println(part2(input))
}
