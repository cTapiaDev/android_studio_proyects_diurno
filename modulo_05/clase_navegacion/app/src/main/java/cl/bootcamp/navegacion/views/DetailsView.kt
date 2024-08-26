package cl.bootcamp.navegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import cl.bootcamp.navegacion.components.MainButton
import cl.bootcamp.navegacion.components.MainIconButton
import cl.bootcamp.navegacion.components.Space
import cl.bootcamp.navegacion.components.TitleBar
import cl.bootcamp.navegacion.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Details View") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue
                ),
                navigationIcon = {
                    MainIconButton(
                        icon = Icons.AutoMirrored.Default.ArrowBack)
                    {
                        navController.popBackStack()
                    }
                }
            )
        },
    ) {
        ContentDetailsView(navController)
    }
}

@Composable
fun ContentDetailsView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Details View")
        Space()
        MainButton(name = "Home View", backColor = Color.Blue, color = Color.White) {
            navController.popBackStack()
        }
    }
}