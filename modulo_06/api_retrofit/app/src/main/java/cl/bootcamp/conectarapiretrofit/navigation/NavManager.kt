package cl.bootcamp.conectarapiretrofit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.bootcamp.conectarapiretrofit.viewModels.GamesViewModel
import cl.bootcamp.conectarapiretrofit.views.DetailView
import cl.bootcamp.conectarapiretrofit.views.HomeView
import cl.bootcamp.conectarapiretrofit.views.SearchGameView

@Composable
fun NavManager(viewModel: GamesViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(viewModel, navController)
        }
        composable("DetailView/{id}", arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )) {
            val id = it.arguments?.getInt("id") ?: 0
            DetailView(viewModel, navController, id)
        }
        composable("SearchGameView") {
            SearchGameView(viewModel, navController)
        }
    }
}