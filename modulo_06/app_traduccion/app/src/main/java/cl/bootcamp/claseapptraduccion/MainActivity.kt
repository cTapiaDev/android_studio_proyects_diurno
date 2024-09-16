package cl.bootcamp.claseapptraduccion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import cl.bootcamp.claseapptraduccion.languages.LanguagesView
import cl.bootcamp.claseapptraduccion.translator.TranslateView
import cl.bootcamp.claseapptraduccion.translator.TranslateViewModel
import cl.bootcamp.claseapptraduccion.ui.theme.ClaseAppTraduccionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: TranslateViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            ClaseAppTraduccionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //MyView(innerPadding)
                    //LanguagesView(innerPadding)
                    TranslateView(innerPadding, viewModel)
                }
            }
        }
    }
}

@Composable
fun MyView(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(R.string.title), fontWeight = FontWeight.Bold)
        Text(text = stringResource(R.string.subtitle))
    }
}