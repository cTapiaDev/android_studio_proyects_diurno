package cl.bootcamp.appfirebasenotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.appfirebasenotes.viewModels.LoginViewModel
import cl.bootcamp.appfirebasenotes.viewModels.NotesViewModel
import cl.bootcamp.appfirebasenotes.views.login.BlankView
import cl.bootcamp.appfirebasenotes.views.login.TabsView
import cl.bootcamp.appfirebasenotes.views.notes.HomeView

@Composable
fun NavManager(
    loginViewModel: LoginViewModel,
    notesViewModel: NotesViewModel
) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Blank") {
        composable("Blank") {
            BlankView(navController)
        }
        composable("Login") {
            TabsView(navController, loginViewModel)
        }
        composable("Home") {
            HomeView(navController, notesViewModel)
        }
    }

}