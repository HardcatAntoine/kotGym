package rpg.experimental

import rpg.MessageStorage

/**
 * Experimental implementation for input helper, use with caution.
 * Input capturing based on while - ture loop.
 * It seems to work fine for input handling, but may cause critical issues.
 */
object ExperimentalInputHelper {
    private var failedInputs = 1

    fun captureInput() {
        while (true) {
            showHint()
            val input = readLine().toString().lowercase()

            when {
                input.isExitCommand() -> {
                    // Exit case. Should print some message before stop the program
                    break
                }
                input.hasCommand() -> {
                    if (RoomNavigator.currentRoom() != null) handleGameCommands(input) else handleMenuCommands(input)
                    // For 2D map
//                    if (MatrixNavigator.getCurrentPos() != null) handleGameCommands(input) else handleMenuCommands(input)
                }
                else -> {
                    failedInputs++
                }
            }
        }
    }

    private fun showHint() {
        if (failedInputs % 6 == 0) println(MessageStorage.getHint())
    }

    /**
     * For one dimensional map presentation
     */
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

    /**
     * For two dimensional map presentation
     */
//    private fun handleMenuCommands(input: String) {
//        when {
//            input.isPositiveCommand() -> MatrixNavigator.nextMap(5)
//            input.isNegativeCommand() -> println("That's not an option... You must try it...")
//            else -> failedInputs++
//        }
//    }
//
//    private fun handleGameCommands(input: String) {
//        when (input) {
//            "up" -> MatrixNavigator.goUp()
//            "down" -> MatrixNavigator.goDown()
//            "left" -> MatrixNavigator.goLeft()
//            "right" -> MatrixNavigator.goRight()
//            else -> failedInputs++
//        }
//    }
}