package cl.bootcamp.claseintents.views

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.claseintents.components.BottomNav
import cl.bootcamp.claseintents.navigation.NavManager
import cl.bootcamp.claseintents.navigation.Routes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {
    val navController = rememberNavController()
    val navigationRoutes = listOf(
        Routes.PhoneView,
        Routes.SmsView,
        Routes.EmailView
    )

    Scaffold(
        bottomBar = {
            BottomNav(navController, navigationRoutes)
        }
    ) {
        NavManager(navController)
    }
}