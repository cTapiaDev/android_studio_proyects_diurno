package cl.bootcamp.kotlinconsola

fun main() {

    var dia = 5

    when (dia) {
        1 -> println("Lunes")
        2 -> println("Martes")
        3 -> println("Miercoles")
        4 -> println("Jueves")
        5 -> println("Viernes")
        else -> println("El día ingresado no es valido")
    }

    val x = 25
    when (x) {
        in 1..10 -> println("Esta dentro del rango 1 a 10")
        in 11..20 -> println("Esta dentro del rango 11 a 20")
        else -> println("No esta dentro de ningun rango")
    }

}