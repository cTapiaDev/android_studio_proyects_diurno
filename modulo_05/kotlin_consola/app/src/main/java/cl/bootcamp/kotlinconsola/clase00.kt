package cl.bootcamp.kotlinconsola

fun main() {
    //println("Hola Mundo!")

    // VARIABLES
    var nombre : String = "Deadpool"
    var texto = "Hola mundo"
    texto = "Hola mundo 2"

    var edad : Int = 25
    //var num = 10

    // CONSTANTE
    //val num2 : Double = 15.0


    //println(num2)

    // NULL SAFETY
    var text : String? = ""
    //-----
    text = null

    text?.let {
        println("Tiene un valor")
    }

    // CAMBIAR TIPO DE DATO

    var num1 = 15
    var num2 = "5".toInt()
    var suma = num1 + num2
    println("Suma: $suma")

    // CONCATENACIONES
    var t1 = "Hola"
    var t2 = "Mundo"
    println(t1 + " " + t2)

    var result = t1.plus(" ").plus(t2)
    println(result)

    val array = arrayOf("Hola", "Mundo")
    val r2 = array.joinToString("-")
    println(r2)

    println("$t1 $t2 desde Kotlin")

    // ESCRIBIR EN CONSOLA
    //println("Escribe tu nombre")
    //val user = readln()
    //println(user)

//    println("Ingresa el primer número")
//    var n1 = readln().toInt()
//
//    println("Ingresa el segundo número")
//    var n2 = readln().toInt()
//
//    var sumar = n1 + n2
//    println("La suma es: $sumar")

    // TRY-CATCH
    try {
        println("Ingresa el primer número")
        var n1 = readln().toInt()

        println("Ingresa el segundo número")
        var n2 = readln().toInt()

        var sumar = n1 + n2
        println("La suma es: $sumar")
    } catch (e: NumberFormatException) {
        println("Error: ingresa un dato valido - $e")
    }

}