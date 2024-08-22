package cl.bootcamp.kotlinconsola

fun main() {

    val lista = listOf(1, 2, 3, 4, 5)
    println(lista)
    println(lista[0])

    val colores = listOf("verde", "amarillo", "rojo")
    println(colores)

    val list = mutableListOf(1, 2, 3)
    list.add(4)
    println(list)
    list.add(8)
    println(list)

    list.remove(3)
    println(list)
}