package cl.bootcamp.appwishlist

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
import cl.bootcamp.appwishlist.navigation.NavManager
import cl.bootcamp.appwishlist.ui.theme.AppWishListTheme
import cl.bootcamp.appwishlist.view.HomeView
import cl.bootcamp.appwishlist.viewModel.WishViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: WishViewModel by viewModels()
        setContent {
            AppWishListTheme {
                NavManager(viewModel)
            }
        }
    }
}