package cl.bootcamp.todolistapp

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
import cl.bootcamp.todolistapp.ui.theme.TodoListAppTheme
import cl.bootcamp.todolistapp.viewModels.ListaProductosViewModel
import cl.bootcamp.todolistapp.views.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: ListaProductosViewModel by viewModels()
        setContent {
            TodoListAppTheme {
                HomeView(viewModel)
            }
        }
    }
}