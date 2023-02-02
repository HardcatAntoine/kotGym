package oop

import kotlin.random.Random

class Weapon: Item() {
    val damage: Double = Random.nextDouble(0.0,100.0)
    override fun printInfo() {
        super.printInfo()
        println("Damage: ${String.format("%.2f",damage)}")
    }

}