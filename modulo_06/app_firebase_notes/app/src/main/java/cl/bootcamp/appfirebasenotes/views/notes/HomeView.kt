package cl.bootcamp.appfirebasenotes.views.notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import cl.bootcamp.appfirebasenotes.viewModels.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    navController: NavController,
    notesViewModel: NotesViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Mis Notas") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            notesViewModel.signOut()
                            navController.popBackStack()
                        }
                    ) {
                        Icon(Icons.AutoMirrored.Default.ExitToApp, "")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "HomeView")
        }

    }
}