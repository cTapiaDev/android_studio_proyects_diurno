package cl.bootcamp.appwishlist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.appwishlist.view.AddEditDetailsView
import cl.bootcamp.appwishlist.view.HomeView
import cl.bootcamp.appwishlist.viewModel.WishViewModel

@Composable
fun NavManager(viewModel: WishViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeView(navController)
        }
        composable(Screen.AddScreen.route) {
            AddEditDetailsView(id = 0L, navController, viewModel)
        }
    }
}