package cl.bootcamp.appdescuentos.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cl.bootcamp.appdescuentos.model.CalcularState

class CalcularViewModel3: ViewModel() {

    var state by mutableStateOf(CalcularState())
        private set

    fun onValue(value: String, text: String) {
        when (text) {
            "precio" -> state = state.copy(precio = value)
            "descuento" -> state = state.copy(descuento = value)
        }
    }

    fun calcular() {
        val precio = state.precio
        val descuento = state.descuento

        if (precio != "" && descuento != "") {
            state = state.copy(
                precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble()),
                totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble())
            )
        } else {
            state = state.copy(
                showAlert = true
            )
        }
    }

    private fun calcularDescuento(precio: Double, descuento: Double): Double {
        val result = precio * (1 - descuento / 100)
        return kotlin.math.round(result * 100) / 100.0
    }

    private fun calcularPrecio(precio: Double, descuento: Double): Double {
        val result = precio - calcularDescuento(precio, descuento)
        return kotlin.math.round(result * 100) / 100.0
    }

    fun limpiar() {
        state = state.copy(
            precio = "",
            descuento = "",
            totalDescuento = 0.0,
            precioDescuento = 0.0
        )
    }

    fun calcelAlert() {
        state = state.copy(
            showAlert = false
        )
    }
}