package cl.bootcamp.appfirebasenotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cl.bootcamp.appfirebasenotes.viewModels.LoginViewModel
import cl.bootcamp.appfirebasenotes.viewModels.NotesViewModel
import cl.bootcamp.appfirebasenotes.views.login.BlankView
import cl.bootcamp.appfirebasenotes.views.login.TabsView
import cl.bootcamp.appfirebasenotes.views.notes.AddNoteView
import cl.bootcamp.appfirebasenotes.views.notes.EditNoteView
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
        composable("AddNoteView") {
            AddNoteView(navController, notesViewModel)
        }
        composable("EditNoteView/{idDoc}", arguments = listOf(
            navArgument("idDoc") { type = NavType.StringType }
        )) {
            val idDoc = it.arguments?.getString("idDoc") ?: ""
            EditNoteView(navController, notesViewModel, idDoc)
        }
    }

}