package oop

import kotlin.random.Random

class Amulet: Item() {
    val hpBonus: Int = Random.nextInt(10,100)
    override fun printInfo() {
        super.printInfo()
        println("HP bonus: $hpBonus")
    }
}