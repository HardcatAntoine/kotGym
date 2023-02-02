package lambda

fun main() {
    /*  val summa = sum(b = 1, a = 2)
      println(summa)
      val suuma2 = sum(1, 3) {}
      sum(1, 3) { result ->
          println(result)
      }
      sum(
          a = 1,
          b = 5,
          result = {}
      ) */
    getFirstItem(listOf())

    getFirstTwoItems(listOf("jksdhf", "jgasyute68q")) { first, second ->
        println(first)
        println(second)
    }
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum(a: Int, b: Int, result: (Int) -> Unit) {
    result(a + b)
}

fun getFirstItem(list: List<String>): String {
    if (list.isEmpty()) {
        return ""
    } else {
        return list[0]
    }

}

fun getFirstTwoItems(list: List<String>, result: (String, String) -> Unit) {
    when (list.size) {
        0 -> {
            result("", "")
        }

        1 -> {
            result(list[0], "")
        }

        2 -> {
            result(list[0], list[1])
        }
    }
}