package cl.bootcamp.claseroom

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
import cl.bootcamp.claseroom.navigate.NavManager
import cl.bootcamp.claseroom.ui.theme.ClaseRoomTheme
import cl.bootcamp.claseroom.viewModels.CronometroViewModel
import cl.bootcamp.claseroom.viewModels.CronosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cronometroVM: CronometroViewModel by viewModels()
        val cronosVM: CronosViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            ClaseRoomTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavManager(
                        modifier = Modifier
                            .padding(innerPadding),
                        cronometroVM,
                        cronosVM
                    )
                }
            }
        }
    }
}