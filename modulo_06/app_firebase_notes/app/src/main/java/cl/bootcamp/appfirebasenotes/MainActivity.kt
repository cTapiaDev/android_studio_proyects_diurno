package cl.bootcamp.appfirebasenotes

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
import cl.bootcamp.appfirebasenotes.navigation.NavManager
import cl.bootcamp.appfirebasenotes.ui.theme.AppFirebaseNotesTheme
import cl.bootcamp.appfirebasenotes.viewModels.LoginViewModel
import cl.bootcamp.appfirebasenotes.viewModels.NotesViewModel
import cl.bootcamp.appfirebasenotes.views.login.TabsView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginViewModel: LoginViewModel by viewModels()
        val notesViewModel: NotesViewModel by viewModels()
        setContent {
            AppFirebaseNotesTheme {
                NavManager(loginViewModel, notesViewModel)
            }
        }
    }
}