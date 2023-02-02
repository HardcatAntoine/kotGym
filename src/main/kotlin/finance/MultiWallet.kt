package finance

enum class Currency {
    USD,
    RUB,
    GBP
}

object MultiWallet {
    val accounts: MutableMap<Currency, Float> = mutableMapOf()

    fun openAccount(currency: Currency) {
        when (currency) {
            Currency.USD -> openIfCan(currency)
            Currency.GBP -> openIfCan(currency)
            Currency.RUB -> openIfCan(currency)
        }
    }

    private fun openIfCan(currency: Currency) {
        if (accounts[currency] != null) {
            accounts.put(currency, 0f)
        }
    }

    fun printBalance() {
        if (accounts.isEmpty()) {
            println("You don't have any accounts")
            return
        }
        println("Account | Balance")
        println("=================")
        accounts.forEach { (currency, balance) ->
            when (currency) {
                Currency.GBP -> println("$currency     | $balance £")
                Currency.RUB -> println("$currency     | $balance ₽")
                Currency.USD -> println("$currency     | $balance $")
            }
        }
        println("=================")
    }

    fun deposit(currency: Currency, amount: Float) {
        if (accounts.containsKey(currency)) {
            when (currency) {
                Currency.USD -> accounts[currency] = accounts[currency]!! + amount
                Currency.RUB -> accounts[currency] = accounts[currency]!! + amount
                Currency.GBP -> accounts[currency] = accounts[currency]!! + amount
            }
        } else {
            println("You don't have this account")
        }
    }

    fun withdraw(currency: Currency, amount: Float) {
        if (accounts.containsKey(currency)) {
            when (currency) {
                Currency.GBP -> withdrawIfCan(currency, amount)
                Currency.USD -> withdrawIfCan(currency, amount)
                Currency.RUB -> withdrawIfCan(currency, amount)
            }
        } else {
            println("You don't have this account")
        }
    }

    private fun withdrawIfCan(currency: Currency, amount: Float) {
        if (accounts[currency]!! >= amount) {
            accounts[currency] = accounts[currency]!! - amount
        } else {
            println("Not enough money on this account")
        }
    }

    fun closeAccount(currency: Currency) {
        when (currency) {
            Currency.USD -> closeIfCan(currency)
            Currency.RUB -> closeIfCan(currency)
            Currency.GBP -> closeIfCan(currency)
        }
    }

    private fun closeIfCan(currency: Currency) {
        if (accounts[currency] != null) {
            accounts.remove(currency)
        }
    }
}