package oop

import kotlin.random.Random

class Ring: Item() {
    val mpBonus : Int = Random.nextInt(10,100)
    override fun printInfo() {
        super.printInfo()
        println("MP bonus: $mpBonus")
    }
}