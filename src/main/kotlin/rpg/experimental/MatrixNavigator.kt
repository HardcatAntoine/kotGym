package rpg.experimental

import rpg.Room

object MatrixNavigator {
    private const val size = 6
    private var map = MatrixMapGenerator.generateMap(size)

    fun printMap() {
        map.forEach { columns ->
            print("+")
            println("---+".repeat(size))
            print("|")
            columns.forEach { room ->
                when {
                    room.isHere() -> print(" @ |")
                    room.isExit() -> print(" X |")
                    else -> print("   |")
                }
            }
            println()
        }
        print("+")
        println("---+".repeat(size))
    }

    fun getAdjacent(
        matrix: Array<IntArray>,
        row: Int,
        column: Int,
    ): List<Int> {
        val rowCount = matrix.size
        val columnCount = matrix[0].size

        if (row >= rowCount || column >= columnCount) {
            println("You are out of bounds...")
            return emptyList()
        }

        val result = ArrayList<Int>()

        val xFirstBound = if (row > 0) -1 else 0
        val xSecondBound = if (row < rowCount - 1) 1 else 0

        val yFirstBound = if (column > 0) -1 else 0
        val ySecondBound = if (column < columnCount - 1) 1 else 0

        for (rowStep in xFirstBound..xSecondBound) {
            for (columnStep in yFirstBound..ySecondBound) {
                if (rowStep != 0 || columnStep != 0) {
                    result.add(matrix[row + rowStep][column + columnStep])
                }
            }
        }

        return result
    }
}