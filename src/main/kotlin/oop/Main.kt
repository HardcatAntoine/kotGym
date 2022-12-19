package oop

fun main() {
    val inventory: Inventory = Inventory(3)
    inventory.addWeapon(Weapon())
    inventory.addWeapon(Weapon())
    inventory.addWeapon(Weapon())
    inventory.addWeapon(Weapon())


    inventory.printInventory()
}