package cl.bootcamp.pruebacertificacionejemplo.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import cl.bootcamp.pruebacertificacionejemplo.components.CardUser
import cl.bootcamp.pruebacertificacionejemplo.viewModel.WalletViewModel

@Composable
fun HomeView(
    viewModel: WalletViewModel,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        viewModel.getAllAPI()
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        val users by viewModel.users.collectAsState(listOf())

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            items(users) { item ->
                CardUser(
                    item.nombre,
                    item.pais,
                    item.imagenLink,
                    item.cuenta
                ) {
                    navController.navigate("DetailsView/${item.id}")
                }
            }
        }
    }

}