package cl.bootcamp.claseroom.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.claseroom.R
import cl.bootcamp.claseroom.components.CircleButton
import cl.bootcamp.claseroom.components.MainIconButton
import cl.bootcamp.claseroom.components.MainTextField
import cl.bootcamp.claseroom.components.MainTitle
import cl.bootcamp.claseroom.components.formatTiempo
import cl.bootcamp.claseroom.model.Cronos
import cl.bootcamp.claseroom.viewModels.CronometroViewModel
import cl.bootcamp.claseroom.viewModels.CronosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditView(
    navController: NavController,
    cronometroVM: CronometroViewModel,
    cronosVM: CronosViewModel,
    id: Long
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { MainTitle(title = "EDIT APP") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.AutoMirrored.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentEditView(it, navController, cronometroVM, cronosVM, id)
    }
}

@Composable
fun ContentEditView(
    it: PaddingValues,
    navController: NavController,
    cronometroVM: CronometroViewModel,
    cronosVM: CronosViewModel,
    id: Long
) {
    val state = cronometroVM.state

    LaunchedEffect(state.cronoActivo) {
        cronometroVM.cronos()
    }
    LaunchedEffect(Unit) {
        cronometroVM.getCronoById(id)
    }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formatTiempo(cronometroVM.tiempo),
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            //Iniciar
            CircleButton(
                icon = painterResource(R.drawable.icon_play_arrow),
                enabled = !state.cronoActivo
            ) {
                cronometroVM.iniciar()
            }

            //Pausar
            CircleButton(
                icon = painterResource(R.drawable.icon_pause),
                enabled = state.cronoActivo
            ) {
                cronometroVM.pausar()
            }
        }

            MainTextField(
                value = state.title,
                onValueChange = { cronometroVM.onValue(it) },
                label = "Titulo"
            )

            Button(
                onClick = {
                    cronosVM.updateCrono(
                        Cronos(
                            id = id,
                            title = state.title,
                            crono = cronometroVM.tiempo
                        )
                    )
                    cronometroVM.detener()
                    navController.popBackStack()
                }
            ) {
                Text(text = "Editar")
            }

        DisposableEffect(Unit) {
            onDispose {
                cronometroVM.detener()
            }
        }
    }
}