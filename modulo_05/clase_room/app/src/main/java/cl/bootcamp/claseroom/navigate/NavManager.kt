package cl.bootcamp.claseroom.navigate

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.claseroom.view.AddView
import cl.bootcamp.claseroom.view.EditView
import cl.bootcamp.claseroom.view.HomeView

@Composable
fun NavManager(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController)
        }
        composable("AddView") {
            AddView(navController)
        }
        composable("EditView") {
            EditView(navController)
        }
    }
}