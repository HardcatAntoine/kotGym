package rpg.experimental

import rpg.Room
import kotlin.random.Random

object MatrixMapGenerator {
    fun generateMap(mapSize: Int): Array<Array<Room>> {
        val roomsCount = mapSize * mapSize
        var roomsCounter = 0
        val exit = Random.nextInt(roomsCount / 2, roomsCount)
        val start = Random.nextInt(1, roomsCount / 2)

        println("EXIT: $exit | START: $start | ROOMS: ${mapSize * mapSize}")
        return Array(mapSize) {
            Array(mapSize) {
                roomsCounter++
                when (roomsCounter) {
                    exit -> {
                        Room(isExit = true)
                    }
                    start -> {
                        Room(isHere = true)
                    }
                    else -> {
                        Room()
                    }
                }
            }
        }
    }
}