package rpg

object InputHelper {
    var failureInputCount = 1

    fun captureInput() {
        val input = readLine().toString().lowercase()

        if (failureInputCount % 5 == 0) {
            println(MessageStorage.getHint())
        }
        when (input) {
            "exit", "no" -> {
                return
            }

            "yes" -> {
                RoomHelper.createRoom()
            }

            else -> {
                failureInputCount++
                captureInput()
            }
        }


    }
}