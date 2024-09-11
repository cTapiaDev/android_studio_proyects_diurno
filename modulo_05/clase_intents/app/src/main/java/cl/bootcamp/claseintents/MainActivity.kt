package cl.bootcamp.claseintents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cl.bootcamp.claseintents.ui.theme.ClaseIntentsTheme
import cl.bootcamp.claseintents.views.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ClaseIntentsTheme {
                HomeView()
            }
        }
    }
}