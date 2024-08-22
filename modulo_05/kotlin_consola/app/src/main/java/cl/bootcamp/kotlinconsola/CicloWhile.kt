package cl.bootcamp.kotlinconsola

fun main() {

//    var num = 1
//    while (num <= 10) {
//        println(num)
//        num++
//    }

    var n1 : Int
    var n2 : Int

    while (true) {
        try {
            println("Ingresa el primer número")
            n1 = readln().toInt()

            println("Ingresa el segundo número")
            n2 = readln().toInt()
            break

        } catch (e: NumberFormatException) {
            println("Error: ingresa un dato valido - $e")
        }
    }

    val res = n1 + n2
    println("La suma es: $res")



}