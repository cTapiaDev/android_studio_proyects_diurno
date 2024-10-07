package cl.bootcamp.appfirebasenotes.views.notes

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.appfirebasenotes.viewModels.NotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNoteView(
    navController: NavController,
    notesViewModel: NotesViewModel,
    idDoc: String
) {
    LaunchedEffect(Unit) {
        notesViewModel.getNoteById(idDoc)
    }
    val state = notesViewModel.state

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Editar Nota") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, "")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            notesViewModel.deleteNote(idDoc) {
                                navController.popBackStack()
                            }
                        }
                    ) {
                        Icon(Icons.Default.Delete, "")
                    }
                    IconButton(onClick = {
                        notesViewModel.updateNote(idDoc) {
                            navController.popBackStack()
                        }
                    }) {
                        Icon(Icons.Default.Edit, "")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = state.title,
                onValueChange = { notesViewModel.onValue(it, "title") },
                label = { Text(text = "Titulo") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )

            OutlinedTextField(
                value = state.note,
                onValueChange = { notesViewModel.onValue(it, "note") },
                label = { Text(text = "Nota") },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(20.dp, 10.dp, 20.dp, 20.dp)
            )
        }
    }
}