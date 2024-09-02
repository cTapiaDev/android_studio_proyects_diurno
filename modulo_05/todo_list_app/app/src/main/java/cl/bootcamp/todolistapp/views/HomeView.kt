package cl.bootcamp.todolistapp.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cl.bootcamp.todolistapp.components.AddButton
import cl.bootcamp.todolistapp.components.Modal
import cl.bootcamp.todolistapp.model.ProductoState
import cl.bootcamp.todolistapp.viewModels.ListaProductosViewModel

@Composable
fun HomeView(viewModel: ListaProductosViewModel) {
    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AddButton(text = "Agregar Producto") {
            viewModel.abrirModal()
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(viewModel.listaProductos) { item ->
                if (item.esEditado) {
                    EditarProducto(
                        item = item
                    ) {
                        nombreEditado, cantidadEditada ->
                        viewModel.listaProductos = viewModel.listaProductos.map { it.copy(esEditado = false) }
                        val elementoEditado = viewModel.listaProductos.find { it.id == item.id }
                        elementoEditado?.let {
                            it.nombre = nombreEditado
                            it.cantidad = cantidadEditada
                        }
                    }
                } else {
                    CardProducto(
                        item = item,
                        onEditClick = {
                            viewModel.listaProductos = viewModel.listaProductos.map {
                                it.copy(esEditado = it.id == item.id)
                            }
                        },
                        onDeleteClick = { viewModel.listaProductos -= item }
                    )
                }
            }
        }


    }

    if (state.mostrarModal) {
        Modal(
            title = "Agregar un Producto",
            onDismissClick = { viewModel.cerrarModal() },
            onText = {
                Column {
                    OutlinedTextField(
                        value = state.nombreProducto,
                        onValueChange = { viewModel.onValue(it, "nombreProducto") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )

                    OutlinedTextField(
                        value = state.cantidadProducto,
                        onValueChange = { viewModel.onValue(it, "cantidadProducto") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            },
            onConfirmClick = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    AddButton(text = "Cerrar") {
                        viewModel.cerrarModal()
                    }
                    AddButton(text = "Agregar") {
                        if (state.nombreProducto.isNotBlank()) {
                            viewModel.agregarProducto(
                                state.nombreProducto,
                                state.cantidadProducto
                            )
                            viewModel.cerrarModal()
                            viewModel.limpiar()
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun CardProducto(
    item: ProductoState,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .border(
                border = BorderStroke(
                    2.dp,
                    Color(0XFF018786)
                ),
                shape = RoundedCornerShape(20)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = item.nombre,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Cant: ${item.cantidad}",
            modifier = Modifier.padding(8.dp)
        )
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            IconButton(onClick = onEditClick) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }
            IconButton(onClick = onDeleteClick) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }

    }
}

@Composable
fun EditarProducto(
    item: ProductoState,
    onEditComplete: (String, Int) -> Unit
) {
    var nombreEditado by remember { mutableStateOf(item.nombre) }
    var cantidadEditada by remember { mutableStateOf(item.cantidad.toString()) }
    var esEditado by remember { mutableStateOf(item.esEditado) }
    
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column {
            BasicTextField(
                value = nombreEditado,
                onValueChange = { nombreEditado = it },
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
            BasicTextField(
                value = cantidadEditada,
                onValueChange = { cantidadEditada = it },
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
        }
        Button(
            onClick = {
                esEditado = false
                onEditComplete(nombreEditado, cantidadEditada.toIntOrNull() ?: 1)
            }
        ) {
            Text(text = "Editar")
        }
    }
}