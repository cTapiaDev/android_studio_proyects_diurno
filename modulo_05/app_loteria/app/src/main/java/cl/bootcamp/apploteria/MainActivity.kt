package cl.bootcamp.apploteria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import cl.bootcamp.apploteria.ui.theme.AppLoteriaTheme
import cl.bootcamp.apploteria.viewModels.LoteriaViewModel
import cl.bootcamp.apploteria.views.LoteriaView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: LoteriaViewModel by viewModels()
        setContent {
            AppLoteriaTheme {
                LoteriaView(viewModel = viewModel)
            }
        }
    }
}