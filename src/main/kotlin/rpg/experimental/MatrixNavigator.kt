package rpg.experimental

import rpg.Room

object MatrixNavigator {
    private var generator = MatrixMapGenerator(3)
    private var map: Array<Array<Pair<RoomPosition, Room>>>? = null
    fun getMap() = map

    fun getGenerator() = generator

    fun getCurrentPos() = generator.getCurrentPos()

    fun setCurrentPos(position: Pair<Int, Int>) {
        generator.setCurrentPos(position)
    }

    fun nextMap(size: Int) {
        generator = MatrixMapGenerator(size)
        map = generator.generateMap()
        printMap()
    }

    private fun printMap() {
        map!!.forEach { columns ->
            print("+")
            println("---+".repeat(map!!.size))
            print("|")
            columns.forEach { element ->
                when {
                    element.second.isHere() -> print(" @ |")
                    element.second.isExit() -> print(" X |")
                    else -> print("   |")
                }
            }
            println()
        }
        print("+")
        println("---+".repeat(map!!.size))
    }

    fun <T : Any> getAdjacent(
        matrix: Array<Array<T>>,
        row: Int,
        column: Int,
    ): List<T> {
        val rowCount = matrix.size
        val columnCount = matrix[0].size

        if (row >= rowCount || column >= columnCount) {
            println("You are out of bounds...")
            return emptyList()
        }

        val result = ArrayList<T>()

        val rowBounds = ((if (row > 0) -1 else 0)..if (row < rowCount - 1) 1 else 0)
        val columnBounds = ((if (column > 0) -1 else 0)..(if (column < columnCount - 1) 1 else 0))

        for (rowStep in rowBounds) {
            for (columnStep in columnBounds) {
                if (rowStep != 0 || columnStep != 0) {
                    result.add(matrix[row + rowStep][column + columnStep])
                }
            }
        }

        return result
    }

    fun goUp() {
        val currentPos = getCurrentPos()
        val currentRow = currentPos!!.first
        val currentColumn = currentPos.second
        val nextRow: Int
        if (currentRow >= 1) {
            nextRow = currentRow - 1
            val nextPos = (nextRow to currentColumn)
            map!![currentRow][currentColumn].second.leaveRoom()
            map!![nextRow][currentColumn].second.enterRoom()
            setCurrentPos(nextPos)
            println("CURRENT POS: ${getCurrentPos()} MAP SIZE: ${map!!.size}")
            printMap()
        } else {
            println("Can't go up...")
            return
        }
    }

    fun goDown() {
        val currentPos = getCurrentPos()
        val currentRow = currentPos!!.first
        val currentColumn = currentPos.second
        val nextRow: Int
        if (currentRow < map!!.size - 1) {
            nextRow = currentRow + 1
            map!![currentRow][currentColumn].second.leaveRoom()
            map!![nextRow][currentColumn].second.enterRoom()
            val nextPos = (nextRow to currentColumn)
            setCurrentPos(nextPos)
            println("CURRENT POS: ${getCurrentPos()} MAP SIZE: ${map!!.size}")
            printMap()
        } else {
            println("Can't go down...")
            return
        }
    }

    fun goLeft() {
        val currentPos = getCurrentPos()
        val currentRow = currentPos!!.first
        val currentColumn = currentPos.second
        val nextColumn: Int
        if (currentColumn >= 1) {
            nextColumn = currentColumn - 1
            map!![currentRow][currentColumn].second.leaveRoom()
            map!![currentRow][nextColumn].second.enterRoom()
            val nextPos = (currentRow to nextColumn)
            setCurrentPos(nextPos)
            println("CURRENT POS: ${getCurrentPos()} MAP SIZE: ${map!!.size}")
            printMap()
        } else {
            println("Can't go left...")
            return
        }
    }

    fun goRight() {
        val currentPos = getCurrentPos()
        val currentRow = currentPos!!.first
        val currentColumn = currentPos.second
        val nextColumn: Int
        if (currentColumn < map!!.size - 1) {
            nextColumn = currentColumn + 1
            map!![currentRow][currentColumn].second.leaveRoom()
            map!![currentRow][nextColumn].second.enterRoom()
            val nextPos = (currentRow to nextColumn)
            setCurrentPos(nextPos)
            println("CURRENT POS: ${getCurrentPos()} MAP SIZE: ${map!!.size}")
            printMap()
        } else {
            println("Can't go right...")
            return
        }
    }
}