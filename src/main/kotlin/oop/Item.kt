package oop

import kotlin.random.Random

open class Item {
    val durability: Double = Random.nextDouble(0.0, 10.0)

    open fun printInfo() {

        print("Durability: ${String.format("%.2f", durability)} | ")

    }
}