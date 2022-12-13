package rpg

object RoomHelper {
    private var roomInstance: Room? = null

    fun createRoom() {
        println("You are entered in the room...")
        roomInstance = Room()
        InputHelper.captureInput()
    }
}