package finance

object InputHandler {
    fun printMenu() {
        while (true) {
            println(
                """Choose Option:
        | 1. Deposit
        | 2. Withdraw
        | 3. Balance
        | 4. Exit
    """.trimMargin()
            )
            when (readLine() ?: "") {
                "1" -> deposit()
                "2" -> withdraw()
                "3" -> balance()
                "4" -> break
                else -> println("WTF?")
            }
        }
    }

    fun deposit() {
        println("Enter amount: ")
        val amount = readLine() ?: ""
        Wallet.deposit(amount.toInt())
        complete()

    }

    fun complete() {
        println("Operation complete")
        Wallet.balance()

    }

    fun withdraw() {
        println("Enter withdraw: ")
        val amount = readLine() ?: ""
        Wallet.withdraw(amount.toInt())
        complete()

    }

    fun balance() {
        Wallet.balance()
    }

}