package rpg.experimental

import rpg.Room
import kotlin.random.Random

class MatrixMapGenerator(
    private val mapSize: Int,
) {
    private val roomsCount = mapSize * mapSize
    private var roomsCounter = 0
    private val exitNumber = Random.nextInt(1, roomsCount / 2)
    private val startNumber = Random.nextInt(roomsCount / 2, roomsCount)
    private var currentPos: Pair<Int, Int>? = null
    private lateinit var exitPos: Pair<Int, Int>

    fun getCurrentPos() = currentPos

    fun setCurrentPos(position: Pair<Int, Int>) {
        currentPos = position
    }

    fun getExitPos() = exitPos

    fun generateMap(): Array<Array<Pair<RoomPosition, Room>>> {
        println("EXIT: $exitNumber | START: $startNumber | ROOMS: ${mapSize * mapSize}")
        return Array(mapSize) { row ->
            Array(mapSize) { column ->
                roomsCounter++
                when (roomsCounter) {
                    exitNumber -> {
                        exitPos = (row to column)
                        (RoomPosition(row, column, roomsCounter) to Room(isExit = true))
                    }
                    startNumber -> {
                        currentPos = (row to column)
                        (RoomPosition(row, column, roomsCounter) to Room(isHere = true))
                    }
                    else -> {
                        (RoomPosition(row, column, roomsCounter) to Room())
                    }
                }
            }
        }
    }
}