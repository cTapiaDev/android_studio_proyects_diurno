package cl.bootcamp.kotlinconsola

fun main() {

    var edad = 18
    var sexo = 'F'

    if (edad === 18) {
        println("Tiene 18 años cumplidos")
        if (sexo === 'M') {
            println("Tiene que cumplir con el servicio militar obligatorio")
        } else {
            println("El servicio militar es opcional")
        }
    } else if (edad > 18) {
        println("Tiene la mayoria de edad")
    } else {
        println("Es menor de edad")
    }

}