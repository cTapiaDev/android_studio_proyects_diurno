package cl.bootcamp.apponboarding.onBoardingViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.apponboarding.dataStore.StoreBoarding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ButtonFinish(currentPage: Int, navController: NavController, store: StoreBoarding) {
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPage != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {
        if (currentPage == 2) {
            OutlinedButton(onClick = {
//                navController.navigate("Home") {
//                    popUpTo(0)
//                }
                CoroutineScope(Dispatchers.IO).launch {
                    store.saveBoarding(true)
                }
            }) {
                Text(
                    text = "Entrar",
                    modifier = Modifier
                        .padding(
                            vertical = 8.dp,
                            horizontal = 40.dp
                        ),
                    color = Color.Gray
                )
            }
        }

    }
}