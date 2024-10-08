package cl.bootcamp.pruebacertificacionejemplo

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
import cl.bootcamp.pruebacertificacionejemplo.navigation.NavManager
import cl.bootcamp.pruebacertificacionejemplo.ui.theme.PruebaCertificacionEjemploTheme
import cl.bootcamp.pruebacertificacionejemplo.viewModel.WalletViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        val viewModel: WalletViewModel by viewModels()
        setContent {
            PruebaCertificacionEjemploTheme {
                NavManager(viewModel)
            }
        }
    }
}