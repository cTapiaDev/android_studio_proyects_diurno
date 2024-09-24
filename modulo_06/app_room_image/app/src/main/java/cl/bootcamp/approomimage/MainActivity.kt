package cl.bootcamp.approomimage

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
import cl.bootcamp.approomimage.navigation.NavManager
import cl.bootcamp.approomimage.ui.theme.AppRoomImageTheme
import cl.bootcamp.approomimage.viewModel.ImagesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        val viewModel: ImagesViewModel by viewModels()
        setContent {
            AppRoomImageTheme {
                NavManager(viewModel)
            }
        }
    }
}