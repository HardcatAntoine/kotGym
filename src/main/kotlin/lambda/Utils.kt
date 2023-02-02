package lambda

fun customRepeat(times: Int, execute: () -> Unit) {
    var t = times
    while (t > 0) {
        execute()
        t--
    }
}