package cl.bootcamp.kotlinconsola

class Personas {
    // Atributos (variables)
    var nombre = ""
    var edad = 0

    // Constructor secundario
    constructor(nombre: String, edad: Int) {
        this.nombre = nombre
        this.edad = edad
    }

    // Métodos (funciones)
    fun saludar() {
        println("Hola, me llamo ${this.nombre} y tengo ${this.edad} años.")
    }
}

class Usuarios(
    private var nombre: String,
    private var email: String
) {
    fun login() {
        println("Login con user: ${this.nombre}, email: ${this.email}")
    }
}

fun main() {

    val persona = Personas("Jorge", 35)
    persona.saludar()

    val user = Usuarios("Pedro", "pedro@gmail.com")
    user.login()

}