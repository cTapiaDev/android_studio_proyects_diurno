package cl.bootcamp.todolistapp.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.bootcamp.todolistapp.model.ProductoState

class ListaProductosViewModel: ViewModel() {

    var state by mutableStateOf(ProductoState())
        private set

    var listaProductos by mutableStateOf(listOf<ProductoState>())

    fun onValue(value: String, text: String) {
        when (text) {
            "nombreProducto" -> state = state.copy(nombreProducto = value)
            "cantidadProducto" -> state = state.copy(cantidadProducto = value)
        }
    }

    fun agregarProducto(nombre: String, cantidad: String) {
        val nuevoProducto = state.copy(
            id = listaProductos.size + 1,
            nombre = nombre,
            cantidad = cantidad.toInt()
        )

        listaProductos += nuevoProducto
    }

    fun limpiar() {
        state = state.copy(nombreProducto = "")
        state = state.copy(cantidadProducto = "1")
    }


    fun abrirModal() {
        state = state.copy(mostrarModal = true)
    }

    fun cerrarModal() {
        state = state.copy(mostrarModal = false)
    }

}