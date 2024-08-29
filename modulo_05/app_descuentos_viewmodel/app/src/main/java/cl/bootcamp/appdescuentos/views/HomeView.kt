package cl.bootcamp.appdescuentos.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cl.bootcamp.appdescuentos.components.Alert
import cl.bootcamp.appdescuentos.components.ContentCards
import cl.bootcamp.appdescuentos.components.MainButton
import cl.bootcamp.appdescuentos.components.MainTextField
import cl.bootcamp.appdescuentos.components.SpaceH

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(modifier: Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "App Descuentos", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        ContentHomeView(it)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var precio by remember { mutableStateOf("") }
        var descuento by remember { mutableStateOf("") }
        var totalDescuento by remember { mutableStateOf(0.0) }
        var precioDescuento by remember { mutableStateOf(0.0) }
        var showAlert by remember { mutableStateOf(false) }

        ContentCards(
            title1 = "Total", number1 = totalDescuento,
            title2 = "Descuento", number2 = precioDescuento
        )

        MainTextField(value = precio, onValueChange = { precio = it }, label = "Precio")
        SpaceH()
        MainTextField(value = descuento, onValueChange = { descuento = it }, label = "Descuento")
        SpaceH()
        MainButton(text = "Generar descuento") {
            if (precio != "" && descuento != "") {
                precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble())
                totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble())
            } else {
                showAlert = true
            }
        }
        SpaceH()
        MainButton(text = "Limpiar", color = MaterialTheme.colorScheme.error) {
            precio = ""
            descuento = ""
            totalDescuento = 0.0
            precioDescuento = 0.0
        }

        if (showAlert) {
            Alert(
                title = "Alerta",
                msj = "Escribe el precio y el descuento",
                confirmText = "Aceptar",
                onConfirmClick = { showAlert = false }
            ) { }
        }
    }
}


fun calcularDescuento(precio: Double, descuento: Double): Double {
    val result = precio * (1 - descuento / 100)
    return kotlin.math.round(result * 100) / 100.0
}

fun calcularPrecio(precio: Double, descuento: Double): Double {
    val result = precio - calcularDescuento(precio, descuento)
    return kotlin.math.round(result * 100) / 100.0
}

