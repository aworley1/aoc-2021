package day04

data class Game(
    val numbers: List<Int>,
    val cards: List<Card>
) {

    fun firstWinningCard(): Pair<Card, Int> {
        val cardsOverTime = numbers.fold(listOf(cards)) { acc, num ->
            acc + listOf(acc.last().map { it.mark(num) })
        }

        val firstWinningTimeIndex = cardsOverTime.mapIndexedNotNull { index, cards ->
            if (cards.any { it.hasWon() }) index else null
        }.first()

        val firstWinningCardIndex =
            cardsOverTime[firstWinningTimeIndex].mapIndexedNotNull { index, card -> if (card.hasWon()) index else null }
                .single()

        return Pair(cardsOverTime[firstWinningTimeIndex][firstWinningCardIndex], numbers[firstWinningTimeIndex - 1])
    }

    fun lastWinningCard(): Pair<Card, Int> {
        val cardsOverTime = numbers.fold(listOf(cards)) { acc, num ->
            acc + listOf(acc.last().map { it.mark(num) })
        }

        val lastWinningTimeIndex = cardsOverTime.mapIndexedNotNull { index, cards ->
            if (cards.all { it.hasWon() }) index else null
        }.first()

        val lastWinningCardIndex: Int = cardsOverTime[lastWinningTimeIndex - 1].mapIndexedNotNull { index, card ->
            if (!card.hasWon()) index else null
        }.single()

        return Pair(cardsOverTime[lastWinningTimeIndex][lastWinningCardIndex], numbers[lastWinningTimeIndex - 1])
    }

}

data class Card(val squares: Map<Coord, Square>) {
    constructor(list: List<Square>) : this(list.associateBy { it.coord })

    private val rows = squares.keys.map { it.row }.distinct()
    private val cols = squares.keys.map { it.column }.distinct()
    private val rowCoords = rows.map { row -> cols.map { Coord(row = row, column = it) } }
    private val colCoords = cols.map { col -> rows.map { Coord(row = it, column = col) } }

    fun mark(number: Int) = Card(squares.mapValues { it.value.mark(number) })

    fun hasWon(): Boolean {
        return colCoords.any { column -> column.all { squares[it]!!.marked } } ||
                rowCoords.any { row -> row.all { squares[it]!!.marked } }
    }

    fun score(number: Int) = squares.values.filterNot { it.marked }.sumOf { it.number } * number
}

data class Square(
    val coord: Coord,
    val number: Int,
    val marked: Boolean = false
) {
    fun mark(number: Int) = if (number == this.number) this.copy(marked = true) else this
}

data class Coord(val row: Int, val column: Int)

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
                                coord = Coord(
                                    row = rowNum,
                                    column = colNum
                                ),
                                number = num.toInt()
                            )
                        }
                }
            )
        }

    return Game(numbers, cards)
}