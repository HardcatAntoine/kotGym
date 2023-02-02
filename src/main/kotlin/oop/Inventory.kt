package oop

class Inventory(private var capacity: Int) {
    companion object {
        const val MAX_GOLD_MULTIPLIER = 2000
    }

    private val weapons: MutableList<Weapon> = mutableListOf()
    private val armors: MutableList<Armor> = mutableListOf()
    private val potions: MutableList<Potion> = mutableListOf()
    private val rings: MutableList<Ring> = mutableListOf()
    private val amulets: MutableList<Amulet> = mutableListOf()
    private var gold: Int = 0
    private val maxGold: Int = MAX_GOLD_MULTIPLIER * capacity

    fun upgradeInventory() {
        capacity++
    }

    fun spendGold(spend: Int) {
        if (gold - spend <= 0) {
            println("Not enough gold")
        } else {
            gold -= spend
        }
    }

    fun addGold(add: Int) {
        if (gold + add >= maxGold) {
            gold = maxGold
            println("You full of gold")
        } else {
            gold += add
        }
    }

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

    fun dropRing() {
        if (rings.isEmpty()) {
            println("Rings is empty")
        } else {
            rings.removeLast()
        }
    }

    fun addRing(ring: Ring) {
        if (rings.size >= capacity) {
            println("Inventory is full")
        } else {
            rings.add(ring)
        }
    }

    fun dropAmulet() {
        if (amulets.isEmpty()) {
            println("Amulet is empty")
        } else {
            amulets.removeLast()
        }
    }

    fun addAmulet(amulet: Amulet) {
        if (amulets.size >= capacity) {
            println("Inventory is full")
        } else {
            amulets.add(amulet)
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

    fun printRings() {
        println("Rings:")
        rings.forEach { ring ->
            println(ring)
        }
    }

    fun printAmulets() {
        println("Amulets:")
        amulets.forEach { amulet ->
            println(amulet)
        }
    }

    fun printInventory() {
        if (armors.isEmpty() && weapons.isEmpty() && potions.isEmpty() && amulets.isEmpty() && rings.isEmpty()) {
            println("Inventory is empty")
        } else {
            printWeapons()
            printArmors()
            printPotions()
            printAmulets()
            printRings()
        }
    }
}

