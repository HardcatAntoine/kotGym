package finance

object MultiInputHandler {
    var currency: Currency = Currency.USD
    fun printMenu() {
        while (true) {
            println(
                """Choose option:
                | 1. Open account
                | 2. Close account
                | 3. Choose account
                | 4. Exit
            """.trimMargin()
            )
            when (readLine() ?: "") {
                "1" -> printOpenAccountMenu()
                "2" -> printCloseAccountMenu()
                "3" -> printChooseAccountMenu()
                "4" -> break
                else -> println("WTF?")
            }
        }
    }

    fun printOpenAccountMenu() {
        println(
            """
            Which currency do you need:
            1. USD
            2. GBP
            3. RUB
            4. Return to main menu
        """.trimIndent()
        )
        when (readLine() ?: "") {
            "1" -> MultiWallet.openAccount(Currency.USD)
            "2" -> MultiWallet.openAccount(Currency.GBP)
            "3" -> MultiWallet.openAccount(Currency.RUB)
            "4" -> return
            else -> println("You don't have this option")
        }
    }

    fun printCloseAccountMenu() {
        println(
            """Which account do you want to close:
            | 1. USD
            | 2. GBP
            | 3. RUB
            | 4. Return to main menu           
        """.trimMargin()
        )
        when (readLine() ?: "") {
            "1" -> MultiWallet.closeAccount(Currency.USD)
            "2" -> MultiWallet.closeAccount(Currency.GBP)
            "3" -> MultiWallet.closeAccount(Currency.RUB)
            "4" -> return
            else -> println("You don't have this option")
        }
    }

    fun printChooseAccountMenu() {
        println(
            """Choose account:
            | 1. USD
            | 2. GBP
            | 3. RUB
            | 4. Return to main menu
        """.trimMargin()
        )
        when (readLine() ?: "") {
            "1" -> {
                currency = Currency.USD
                printOperationMenu()
            }

            "2" -> {
                currency = Currency.GBP
                printOperationMenu()
            }

            "3" -> {
                currency = Currency.RUB
                printOperationMenu()
            }

            "4" -> return
            else -> println("You don't have this option")
        }
    }

    fun printOperationMenu() {
        println(
            """Choose option:
            | 1. Deposit
            | 2. Withdraw
            | 3. Return to main menu
                    """.trimMargin()
        )
        when (readLine() ?: "") {
            "1" -> {
                println("Enter amount: ")
                val amount = readLine()!!.toFloat()
                MultiWallet.deposit(currency, amount)
            }

            "2" -> {
                println("Enter amount: ")
                val amount = readLine()!!.toFloat()
                MultiWallet.withdraw(currency, amount)
            }

            "3" -> return
            else -> println("You don't have this option")
        }
    }

}
