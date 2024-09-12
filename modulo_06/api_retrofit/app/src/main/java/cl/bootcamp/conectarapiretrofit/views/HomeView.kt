package cl.bootcamp.conectarapiretrofit.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cl.bootcamp.conectarapiretrofit.components.MainTopBar
import cl.bootcamp.conectarapiretrofit.viewModels.GamesViewModel

@Composable
fun HomeView(modifier: Modifier, viewModel: GamesViewModel) {
    Scaffold(
        topBar = {
            MainTopBar(title = "API GAMES") { }
        }
    ) {
        ContentHomeView(viewModel, it)
    }
}

@Composable
fun ContentHomeView(viewModel: GamesViewModel, paddingValues: PaddingValues) {
    val games by viewModel.games.collectAsState()

    LazyColumn(
        modifier = Modifier.padding(paddingValues)
    ) {
        items(games) { item ->
            Text(text = item.name)
        }
    }
}