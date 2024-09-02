package cl.bootcamp.todolistapp.model

data class ProductoState(
    var id: Int = 0,
    var nombre: String = "",
    var cantidad: Int = 0,
    var esEditado: Boolean = false,
    var mostrarModal: Boolean = false,
    var nombreProducto: String = "",
    var cantidadProducto: String = ""
)
