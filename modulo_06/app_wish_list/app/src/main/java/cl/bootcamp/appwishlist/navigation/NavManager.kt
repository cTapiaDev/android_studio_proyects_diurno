package cl.bootcamp.appwishlist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.bootcamp.appwishlist.view.AddEditDetailsView
import cl.bootcamp.appwishlist.view.HomeView
import cl.bootcamp.appwishlist.viewModel.WishViewModel

@Composable
fun NavManager(viewModel: WishViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeView(navController,viewModel)
        }
        composable(Screen.AddScreen.route + "/{id}", arguments = listOf(
            navArgument("id") {
                type = NavType.LongType
                defaultValue = 0L
                nullable = false
            }
        )) { entry ->
            val id = if (entry.arguments != null) entry.arguments!!.getLong("id") else 0L
            AddEditDetailsView(id, navController, viewModel)
        }
    }
}