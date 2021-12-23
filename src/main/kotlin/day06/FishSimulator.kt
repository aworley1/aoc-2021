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