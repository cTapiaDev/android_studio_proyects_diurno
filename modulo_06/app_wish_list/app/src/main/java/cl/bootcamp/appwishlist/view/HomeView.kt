package cl.bootcamp.appwishlist.view

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import cl.bootcamp.appwishlist.R
import cl.bootcamp.appwishlist.components.AppBarView
import cl.bootcamp.appwishlist.components.WishItem
import cl.bootcamp.appwishlist.model.DummyWish
import cl.bootcamp.appwishlist.navigation.Screen
import cl.bootcamp.appwishlist.viewModel.WishViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeView(navController: NavController, viewModel: WishViewModel) {
    val context = LocalContext.current
    val wishList = viewModel.getAllWishes.collectAsState(initial = listOf())

    Scaffold(
        topBar = { AppBarView(stringResource(R.string.home)) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddScreen.route + "/0L")
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
            items(wishList.value, key={wish -> wish.id}) { wish ->
                val dismissState = rememberDismissState(
                    confirmStateChange = {
                        if (it == DismissValue.DismissedToEnd || it == DismissValue.DismissedToStart) {
                            viewModel.deleteWish(wish)
                        }
                        true
                    }
                )

                SwipeToDismiss(
                    state = dismissState,
                    background = {
                        val color by animateColorAsState(
                            if (dismissState.dismissDirection
                                == DismissDirection.EndToStart) Color.Red else Color.Transparent
                            , label = ""
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color)
                                .padding(horizontal = 20.dp),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Icon(
                                Icons.Default.Delete,
                                "Delete Icon",
                                tint = Color.White
                            )
                        }
                    },
                    directions = setOf(DismissDirection.EndToStart),
                    dismissContent = {
                        WishItem(wish) {
                            val id = wish.id
                            navController.navigate(Screen.AddScreen.route + "/$id")
                        }
                    }
                )
            }
        }
    }

}