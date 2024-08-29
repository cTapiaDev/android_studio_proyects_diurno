package cl.bootcamp.appdescuentos.model

data class CalcularState(
    val precio: String = "",
    val descuento: String = "",
    val totalDescuento: Double = 0.0,
    val precioDescuento: Double = 0.0,
    val showAlert: Boolean = false
)
