package cl.bootcamp.pruebacertificacionejemplo.view

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.pruebacertificacionejemplo.R
import cl.bootcamp.pruebacertificacionejemplo.components.TopBarComponent
import cl.bootcamp.pruebacertificacionejemplo.viewModel.WalletViewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun DetailsView(
    viewModel: WalletViewModel,
    navController: NavController,
    id: Int
) {
    LaunchedEffect(Unit) {
        viewModel.getUserById(id)
    }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.clean()
        }
    }

    Scaffold(
        topBar = {
            TopBarComponent(
                titulo = "¡Hola ${viewModel.state.nombre}!",
                mostrarBotton = true
            ) { navController.popBackStack() }
        }
    ) {
        ContentDetailView(it, viewModel)
    }
}

@Composable
fun ContentDetailView(
    paddingValues: PaddingValues,
    viewModel: WalletViewModel
) {
    val state = viewModel.state
    val context = LocalContext.current
    val image = rememberAsyncImagePainter(model = state.imagenLink)
    var nuevoNombre = state.nombre.replace(" ", "_")
    var email = "${nuevoNombre}@hotmail.com"
    var asunto = "Formulario de Contacto - ${state.nombre}"
    var mensaje = """Hola
        
        Somos parte del equipo de contacto de Wallet, Te animas a que podamos
        contactarte, para poder recibir información importante.
        
        Número de Contacto: _________
        
        Gracias.
    """.trimIndent()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Image(
            painter = image,
            "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = stringResource(R.string.details_pais) + " ${state.pais}", fontWeight = FontWeight.Bold)
                HorizontalDivider()
                Text(text = "Cuenta: ${state.cuenta}", fontWeight = FontWeight.Bold)
                HorizontalDivider()
                Text(text = "Saldo: ${state.saldo}", fontWeight = FontWeight.Bold)
                HorizontalDivider()
                Text(text = "Depositos: ${state.depositos}", fontWeight = FontWeight.Bold)
                HorizontalDivider()
            }
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_SEND)
                    val emailAddress = arrayOf(email)
                    intent.putExtra(Intent.EXTRA_EMAIL, emailAddress)
                    intent.putExtra(Intent.EXTRA_SUBJECT, asunto)
                    intent.putExtra(Intent.EXTRA_TEXT, mensaje)
                    intent.type = "message/rfc822"
                    context.startActivity(Intent.createChooser(intent, "Email del cliente"))
                }
            ) { Text(text = "Enviar Correo") }
        }
    }

}