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
        InputHelper.captureInput()
    }

    fun enterRoom() {
        isHere = true
    }

    fun isHere() = isHere

    fun isExit() = isExit
}
