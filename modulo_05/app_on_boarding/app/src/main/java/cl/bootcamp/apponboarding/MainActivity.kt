package cl.bootcamp.apponboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.apponboarding.navigation.NavManager
import cl.bootcamp.apponboarding.onBoardingViews.MainOnBoarding
import cl.bootcamp.apponboarding.ui.theme.AppOnBoardingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            AppOnBoardingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //MainOnBoarding(modifier = Modifier.padding(innerPadding))
                    NavManager(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}