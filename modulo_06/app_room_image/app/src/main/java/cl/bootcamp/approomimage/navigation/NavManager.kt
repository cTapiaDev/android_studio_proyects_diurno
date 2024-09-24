package cl.bootcamp.approomimage.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.approomimage.view.AddPhotoView
import cl.bootcamp.approomimage.view.HomeView
import cl.bootcamp.approomimage.viewModel.ImagesViewModel

@Composable
fun NavManager(viewModel: ImagesViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController, viewModel)
        }
        composable("AddPhotoView") {
            AddPhotoView(viewModel)
        }
    }
}