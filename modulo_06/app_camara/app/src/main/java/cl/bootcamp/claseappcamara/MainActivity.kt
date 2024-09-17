package cl.bootcamp.claseappcamara

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
import cl.bootcamp.claseappcamara.ui.theme.ClaseAppCamaraTheme
import cl.bootcamp.claseappcamara.view.TabsView
import cl.bootcamp.claseappcamara.viewModel.ScannerViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: ScannerViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            ClaseAppCamaraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TabsView(viewModel, innerPadding)
                }
            }
        }
    }
}