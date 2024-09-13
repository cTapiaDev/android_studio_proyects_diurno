package cl.bootcamp.conectarapiretrofit.views

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.conectarapiretrofit.components.CardGame
import cl.bootcamp.conectarapiretrofit.components.MainTopBar
import cl.bootcamp.conectarapiretrofit.util.Constants.Companion.CUSTOM_BLACK
import cl.bootcamp.conectarapiretrofit.viewModels.GamesViewModel

@Composable
fun HomeView(viewModel: GamesViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            MainTopBar(title = "API GAMES", onClickBackButton = { }) {
                navController.navigate("SearchGameView")
            }
        }
    ) {
        ContentHomeView(viewModel, it, navController)
    }
}

@Composable
fun ContentHomeView(
    viewModel: GamesViewModel,
    paddingValues: PaddingValues,
    navController: NavController
) {
    val games by viewModel.games.collectAsState()

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .background(Color(CUSTOM_BLACK))
    ) {
        items(games) { item ->
            CardGame(item) {
                navController.navigate("DetailView/${item.id}")
            }
            Text(
                text = item.name,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
        }
    }
}