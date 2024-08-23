package cl.bootcamp.kotlinconsola

fun main() {

    val num = listOf(1, 2, 3, 4, 5)
    val suma = sumarLista(num)
    println("La suma de la lista es: $suma")

    val pares = listOf(2, 3, 8, 9, 10, 20, 25, 6, 4)
    val listaPares = filtrarPares(pares)
    println(listaPares)

}

fun sumarLista(lista: List<Int>): Int {
    // Programación imperativa
//    var res = 0
//    for (i in lista) {
//        res += i
//    }
//    return res

    // Programación declarativa
    return lista.sum()
}

fun filtrarPares(lista: List<Int>): List<Int> {
    // Programación imperativa
//    val res = mutableListOf<Int>()
//    for (i in lista) {
//        if (i % 2 == 0) {
//            res.add(i)
//        }
//    }
//    return res

    // Programación declarativa
    return lista.filter { it % 2 == 0 }.toList()
}

