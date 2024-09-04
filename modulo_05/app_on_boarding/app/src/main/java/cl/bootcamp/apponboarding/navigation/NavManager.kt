package cl.bootcamp.apponboarding.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.bootcamp.apponboarding.dataStore.StoreBoarding
import cl.bootcamp.apponboarding.onBoardingViews.MainOnBoarding
import cl.bootcamp.apponboarding.views.HomeView
import cl.bootcamp.apponboarding.views.SplashScreen

@Composable
fun NavManager(modifier: Modifier) {
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getBoarding.collectAsState(initial = false)

    val navController = rememberNavController()
    NavHost(navController, startDestination = if (store.value) "Home" else "Splash") {
        composable("OnBoarding") {
            MainOnBoarding(modifier = Modifier, navController, dataStore)
        }
        composable("Home") {
            HomeView()
        }
        composable("Splash") {
            SplashScreen(navController, store.value)
        }
    }
}