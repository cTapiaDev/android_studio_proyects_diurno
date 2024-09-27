package cl.bootcamp.appcategoriasapi

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
import cl.bootcamp.appcategoriasapi.ui.theme.AppCategoriasAPITheme
import cl.bootcamp.appcategoriasapi.view.CategoryView
import cl.bootcamp.appcategoriasapi.viewModel.CategoryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: CategoryViewModel by viewModels()
        setContent {
            AppCategoriasAPITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CategoryView(innerPadding, viewModel)
                }
            }
        }
    }
}