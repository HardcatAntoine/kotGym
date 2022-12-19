package oop

class Inventory(private val capacity: Int) {
    private val weapons: MutableList<Weapon> = mutableListOf()
    private val armors: MutableList<Armor> = mutableListOf()
    private val potions: MutableList<Potion> = mutableListOf()

    fun dropWeapon() {
        if (weapons.isEmpty()) {
            println("Weapons are empty")
        } else {
            weapons.removeLast()
        }
    }

    fun addWeapon(weapon: Weapon) {
        if (weapons.size >= capacity) {
            println("Inventory is full")
        } else {
            weapons.add(weapon)
        }
    }

    fun dropArmor() {
        if (armors.isEmpty()) {
            println("Armors are empty")
        } else {
            armors.removeLast()
        }
    }

    fun addArmor(armor: Armor) {
        if (armors.size >= capacity) {
            println("Inventory is full")
        } else {
            armors.add(armor)
        }
    }

    fun dropPotion() {
        if (potions.isEmpty()) {
            println("Potions are empty")
        } else {
            potions.removeLast()
        }
    }

    fun addPotion(potion: Potion) {
        if (potions.size >= capacity) {
            println("Inventory is full")
        } else {
            potions.add(potion)
        }
    }

    fun printWeapons() {
        println("Weapons:")
        weapons.forEach { weapon ->
            println(weapon)
        }
    }

    fun printArmors() {
        println("Armors:")
        armors.forEach { armor ->
            println(armor)
        }
    }

    fun printPotions() {
        println("Potions:")
        potions.forEach { potion ->
            println(potion)
        }
    }

    fun printInventory() {
        if (armors.isEmpty() && weapons.isEmpty() && potions.isEmpty()) {
            println("Inventory is empty")
        } else {
            printWeapons()
            printArmors()
            printPotions()

        }
    }
}

