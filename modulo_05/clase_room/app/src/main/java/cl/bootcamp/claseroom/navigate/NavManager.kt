package cl.bootcamp.claseroom.navigate

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.bootcamp.claseroom.view.AddView
import cl.bootcamp.claseroom.view.EditView
import cl.bootcamp.claseroom.view.HomeView
import cl.bootcamp.claseroom.viewModels.CronometroViewModel
import cl.bootcamp.claseroom.viewModels.CronosViewModel

@Composable
fun NavManager(
    modifier: Modifier,
    cronometroVM: CronometroViewModel,
    cronosVM: CronosViewModel
) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController, cronosVM)
        }
        composable("AddView") {
            AddView(navController, cronometroVM, cronosVM)
        }
        composable("EditView/{id}", arguments = listOf(
            navArgument("id") { type = NavType.LongType }
        )) {
            val id = it.arguments?.getLong("id") ?: 0
            EditView(navController, cronometroVM, cronosVM, id)
        }
    }
}