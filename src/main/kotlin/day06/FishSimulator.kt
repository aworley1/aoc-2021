package day06

fun simulate(fish: List<Int>): List<Int> {
    return fish
        .map { it - 1 }
        .flatMap {
            when (it) {
                -1 -> listOf(6, 8)
                else -> listOf(it)
            }
        }
}

fun simulateV2(population: Map<Int, Long>): Map<Int, Long> {
    return mapOf(
        0 to population[1]!!,
        1 to population[2]!!,
        2 to population[3]!!,
        3 to population[4]!!,
        4 to population[5]!!,
        5 to population[6]!!,
        6 to population[7]!! + population[0]!!,
        7 to population[8]!!,
        8 to population[0]!!,
    )
}
