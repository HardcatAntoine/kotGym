package rpg

object MessageStorage {
   private val hints = listOf(
        "Trying to type something meaningful...",
        "Are you retarded or just dumb?",
        "Oh gosh... Are you kidding?"
    )
    fun getHint(): String {
        return hints.random()
    }
}