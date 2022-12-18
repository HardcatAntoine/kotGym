package rpg.experimental

private val EXIT_COMMANDS = listOf("exit", "quit", "stop")
private val YES_COMMANDS = listOf("yes", "y", "yeah")
private val NO_COMMANDS = listOf("no", "n", "not")
private val NEXT_COMMANDS = listOf("next")
private val PREV_COMMANDS = listOf("prev")
private val INSPECT_COMMANDS = listOf("inspect")
private val MAP_COMMANDS = listOf("map")
private val UP_COMMANDS = listOf("up")
private val DOWN_COMMANDS = listOf("down")
private val LEFT_COMMANDS = listOf("left")
private val RIGHT_COMMANDS = listOf("right")
private val COMMANDS_LIST: List<String> =
    EXIT_COMMANDS + YES_COMMANDS + NO_COMMANDS + NEXT_COMMANDS +
            INSPECT_COMMANDS + PREV_COMMANDS + MAP_COMMANDS + UP_COMMANDS +
            DOWN_COMMANDS + LEFT_COMMANDS + RIGHT_COMMANDS

fun String.isExitCommand(): Boolean {
    return this in EXIT_COMMANDS
}

fun String.isPositiveCommand(): Boolean {
    return this in YES_COMMANDS
}

fun String.isNegativeCommand(): Boolean {
    return this in NO_COMMANDS
}

fun String.hasCommand(): Boolean {
    return this in COMMANDS_LIST
}