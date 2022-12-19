package rpg

import rpg.experimental.*

object InputHelper {
    var failedInputs = 1

    fun captureInput() {
        while (true) {
            if (failedInputs % 5 == 0) {
                println(MessageStorage.getHint())
            }
            val input = readLine().toString().lowercase()
            when {
                input.isExitCommand() -> {
                    // Exit case. Should print some message before stop the program
                    break
                }
                input.hasCommand() -> {
                    if (RoomNavigator.currentRoom() != null) handleGameCommands(input) else handleMenuCommands(
                        input
                    )
                }
                else -> {
                    failedInputs++
                }
            }
        }
    }

    private fun handleMenuCommands(input: String) {
        when {
            input.isPositiveCommand() -> RoomNavigator.nextRoom()
            input.isNegativeCommand() -> println("That's not an option... You must try it...")
            else -> failedInputs++
        }
    }

    private fun handleGameCommands(input: String) {
        when (input) {
            "next" -> RoomNavigator.nextRoom()
            "prev" -> RoomNavigator.previousRoom()
            "inspect" -> RoomNavigator.inspectRoom()
            "map" -> RoomNavigator.printMap()
            else -> failedInputs++
        }
    }

}