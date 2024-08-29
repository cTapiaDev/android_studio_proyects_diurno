package cl.bootcamp.appdescuentos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.appdescuentos.ui.theme.AppDescuentosTheme
import cl.bootcamp.appdescuentos.viewModels.CalcularViewModel1
import cl.bootcamp.appdescuentos.viewModels.CalcularViewModel2
import cl.bootcamp.appdescuentos.viewModels.CalcularViewModel3
import cl.bootcamp.appdescuentos.views.HomeView
import cl.bootcamp.appdescuentos.views.HomeView2
import cl.bootcamp.appdescuentos.views.HomeView3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //val viewModel1: CalcularViewModel1 by viewModels()
        //val viewModel2: CalcularViewModel2 by viewModels()
        val viewModel3: CalcularViewModel3 by viewModels()
        setContent {
            AppDescuentosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    HomeView(modifier = Modifier.padding(innerPadding), viewModel1)
                    //HomeView2(modifier = Modifier.padding(innerPadding), viewModel2)
                    HomeView3(modifier = Modifier.padding(innerPadding), viewModel3)
                }
            }
        }
    }
}