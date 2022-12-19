package rpg

import kotlin.random.Random

class Room(
    private var isHere: Boolean = false,
    private val isExit: Boolean = false,
) {
    var doors = Random.nextInt(1, 5)

    fun inspectRoom() {
        println("Дверей = $doors")
    }

    fun openDoor() {
        RoomHelper.createRoom()
    }

    fun enterRoom() {
        isHere = true
    }

    fun leaveRoom() {
        isHere = false
    }

    fun isHere() = isHere

    fun isExit() = isExit
}
