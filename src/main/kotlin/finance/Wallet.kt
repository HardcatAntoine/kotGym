package finance

object Wallet {
    var money: Int = 0
    fun deposit(amount: Int) {
        money = money + amount
    }

    fun withdraw(amount: Int): Int {
        if (money >= amount) {
            money = money - amount
            return amount
        } else {
            println("Not enough money")
            return 0
        }
    }

    fun balance() {
        println("Balance = $money")
    }
}