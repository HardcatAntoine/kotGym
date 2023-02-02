package oop

fun main() {

    val mapWithList: MutableMap<String, List<Item>> = mutableMapOf()
    /*

        val map: MutableMap<Int, String> = mutableMapOf()

map.put(1,"Pavel")
    map.put(2,"Anton")
    map[3] = "Lera"
    map.put(4,"Anna")
    map.forEach{element ->
        println("${element.key} -> ${element.value}")
    }
    map[1] = "Toyota"
    map[2] = "BMW"
    map[3] = "Audi"
    map[4] = "Lexus"
    map.forEach{(key,value)->
        println("$key -> $value")
    }
    */
    mapWithList["Amulets"] = mutableListOf(Amulet(), Amulet(), Amulet())
    mapWithList["Rings"] = mutableListOf(Ring(), Ring())
    mapWithList["Weapons"] = mutableListOf(Weapon())

    printMapItems(mapWithList)
    //printMapItems(map)
}

fun printMapItems(map: MutableMap<String, List<Item>>) {
    map.forEach { (key, value) ->
        println("$key: ")
        value.forEach { item ->
            item.printInfo()
        }
        println("_____________________________")
    }
}