package rpg

import kotlin.random.Random

class Room () {
    var doors = Random.nextInt(1, 5)

    fun inspectRoom() {
        println("Дверей = $doors")
    }
    fun openDoor() {
        RoomHelper.createRoom()
        InputHelper.captureInput()
    }
}
