package day04

data class Game(
    val numbers: List<Int>,
    val cards: List<Card>
)

data class Card(val squares: List<Square>)

data class Square(
    val row: Int,
    val column: Int,
    val number: Int,
    val marked: Boolean = false
)

fun parseGame(input: List<String>): Game {
    val numbers = input.first().split(",").map { it.toInt() }

    val cards = input.drop(1)
        .filterNot { it.isBlank() }
        .chunked(5)
        .map {
            Card(
                it.flatMapIndexed { rowNum, row ->
                    row.trim().split("\\s+".toRegex())
                        .mapIndexed { colNum, num ->
                            Square(
                                row = rowNum,
                                column = colNum,
                                number = num.toInt()
                            )
                        }
                }
            )
        }

    return Game(numbers, cards)
}