package cl.bootcamp.kotlinconsola

fun main() {

    suma(10, 15)

    val resDivision = division(10.0, 2.0)
    println(resDivision)

    //Funcion Lambda
    val sum = {num1:Int, num2:Int -> println(num1 + num2)}
    val result = sum(12, 12)

}

fun suma(num1:Int, num2:Int): Unit {
    val res = num1 + num2
    println("Suma: $res")
}

// Funcion de retorno
fun division (num1:Double, num2:Double): Double {
    val res = num1 / num2
    return res
}