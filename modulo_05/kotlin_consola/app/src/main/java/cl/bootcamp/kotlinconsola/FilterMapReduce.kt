package cl.bootcamp.kotlinconsola

fun main() {

    // ----------- FILTER -----------
    println("----------- FILTER -----------")
    val nombres = listOf("Luis", "Maria", "Pedro", "Arturo")
    val nombreRes = nombres.filter { it.contains("a", ignoreCase = true) }
    println(nombreRes)

    val personas = listOf(
        Persona("Maria", 35),
        Persona("Pedro", 25),
        Persona("Daniela", 22),
        Persona("Lucia", 30),
        Persona("Luis", 18)
    );

    val mayores = personas.filter { it.edad >= 30 }.map { it.nombre }.sorted()
    println(mayores)

    // ----------- MAP -----------
    println("----------- MAP -----------")
    val listaPersonas = personas.map { it.nombre }
    println(listaPersonas)

    val multiEdad = personas.map { it.edad * 2 }
    println(multiEdad)

    val sumarEdades = personas.map { it.edad }.sum()
    println(sumarEdades)

    val palabras = listOf("hola", "mundo", "kotlin")
    val extPalabras = palabras.map { it.length }
    println(extPalabras)

    // ----------- REDUCE -----------
    println("----------- REDUCE -----------")
    val num = listOf(1, 2, 3, 4, 5)
    val numRes = num.reduce { valorAcumulado, valorActual -> valorAcumulado * valorActual }
    println(numRes)

    val concatenar = palabras.reduce { acumulado, actual -> "$acumulado $actual" }
    println(concatenar)
}

data class Persona(val nombre: String, val edad: Int)