package cl.bootcamp.appwishlist.view

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.appwishlist.R
import cl.bootcamp.appwishlist.components.AppBarView
import cl.bootcamp.appwishlist.components.WishItem
import cl.bootcamp.appwishlist.data.DummyWish
import cl.bootcamp.appwishlist.navigation.Screen

@Composable
fun HomeView(navController: NavController) {
    val context = LocalContext.current

    Scaffold(
        topBar = { AppBarView(stringResource(R.string.home)) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddScreen.route)
                },
                modifier = Modifier
                    .padding(20.dp),
                contentColor = Color.White,
                backgroundColor = Color.Black
            ) {
                Icon(Icons.Default.Add, null)
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(DummyWish.wishList) { wish ->
                WishItem(wish) { }
            }
        }
    }

}