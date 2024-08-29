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
import cl.bootcamp.appdescuentos.viewModels.CalcularViewModel1
import cl.bootcamp.appdescuentos.viewModels.CalcularViewModel2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(modifier: Modifier, viewModel1: CalcularViewModel1) {
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
        ContentHomeView(it, viewModel1)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, viewModel1: CalcularViewModel1) {
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
            val result = viewModel1.calcular(precio, descuento)
            showAlert = result.second.second

            if (!showAlert) {
                precioDescuento = result.first
                totalDescuento = result.second.first
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

