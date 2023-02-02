package oop

class ExperimentalInventory(private val capacity: Int) {
    public val items: MutableList<Item> = mutableListOf()

    fun addItem(item: Item) {
        when (item) {
            is Amulet -> {
                if (items.count { it is Amulet } < capacity) {
                    items.add(item)
                } else {
                    println("Amulet is full")
                }

            }

            is Armor -> {
                if (items.count { it is Armor } < capacity) {
                    items.add(item)
                } else {
                    println("Armor is full")
                }

            }

            is Weapon -> {
                if (items.count { it is Weapon } < capacity) {
                    items.add(item)
                } else {
                    println("Weapon is full")
                }

            }

            is Potion -> {
                if (items.count { it is Potion } < capacity) {
                    items.add(item)
                } else {
                    println("Potion is full")
                }

            }

            is Ring -> {
                if (items.count { it is Ring } < capacity) {
                    items.add(item)
                } else {
                    println("Ring is full")
                }

            }
        }
    }

    fun dropItem(item: Item) {
        when (item) {
            is Amulet -> {
                if (items.count { it is Amulet } >= 1) {
                    items.remove(item)
                } else {
                    println("Amulet is empty")
                }
            }

            is Weapon -> {
                if (items.count { it is Weapon } >= 1) {
                    items.remove(item)
                } else {
                    println("Weapon is empty")
                }

            }

            is Armor -> {
                if (items.count { it is Armor } >= 1) {
                    items.remove(item)
                } else {
                    println("Armor is empty")
                }
            }

            is Potion -> {
                if (items.count { it is Potion } >= 1) {
                    items.remove(item)
                } else {
                    println("Potion is empty")
                }
            }

            is Ring -> {
                if (items.count { it is Ring } >= 1) {
                    items.remove(item)
                } else {
                    println("Ring is empty")
                }
            }
        }
    }
}