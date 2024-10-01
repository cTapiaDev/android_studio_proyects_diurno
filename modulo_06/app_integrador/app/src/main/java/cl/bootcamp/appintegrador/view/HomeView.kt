package cl.bootcamp.appintegrador.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cl.bootcamp.appintegrador.viewModel.UserViewModel

@Composable
fun HomeView(
    paddingValues: PaddingValues,
    viewModel: UserViewModel
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { viewModel.getUser() }
        ) {
            Text(text = "User en Log")
        }
    }
}