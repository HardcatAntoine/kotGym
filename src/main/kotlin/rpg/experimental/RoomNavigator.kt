package rpg.experimental

import rpg.Room

/**
 *  This class gives you ability to move between the rooms.
 *  If room doesn't exist yet, then it will be created.
 *  [nextRoom] - create room if it doesn't exist or move you in to next room.
 *  [previousRoom] - move you to the previous room util the very first room.
 *  [map] - print list of all rooms which was created and indicate you current location.
 */
object RoomNavigator {
    private val rooms = mutableListOf<Room>()
    private var stepsBack = 0
    private var currentRoom: Room? = null

    fun nextRoom() {
        when {
            currentRoom == null -> {
                createRoomInstance()
            }
            rooms.indexOf(currentRoom) == rooms.lastIndex -> {
                createRoomInstance()
            }
            else -> {
                stepsBack--
                currentRoom = rooms[rooms.lastIndex - stepsBack]
                printNavigationInfo()
            }
        }
    }

    private fun createRoomInstance() {
        currentRoom = Room()
        rooms.add(currentRoom!!)
        printNavigationInfo()
    }

    fun previousRoom() {
        if (rooms.lastIndex == stepsBack) {
            println("You can't go back...")
            return
        }
        stepsBack++
        currentRoom = rooms[rooms.lastIndex - stepsBack]
        printNavigationInfo()
    }

    fun inspectRoom() {
        println("Doors count: ${currentRoom!!.doors}")
    }

    fun currentRoom(): Room? {
        return currentRoom
    }

    private fun printNavigationInfo() {
        println("Current room: $currentRoom")
    }

    fun printMap() {
        rooms.forEach { room ->
            if (currentRoom == room) {
                println("$room - You are here")
            } else {
                println("$room")
            }
        }
    }
}