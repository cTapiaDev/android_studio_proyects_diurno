package cl.bootcamp.appwishlist.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.appwishlist.R
import cl.bootcamp.appwishlist.components.AppBarView
import cl.bootcamp.appwishlist.components.Space
import cl.bootcamp.appwishlist.components.WishTextField
import cl.bootcamp.appwishlist.model.Wish
import cl.bootcamp.appwishlist.viewModel.WishViewModel
import kotlinx.coroutines.launch

@Composable
fun AddEditDetailsView(
    id: Long,
    navController: NavController,
    viewModel: WishViewModel
) {
    val snackMessage = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    if (id != 0L) {
        val wish = viewModel.getAWishById(id).collectAsState(initial = Wish(0L, "", ""))
        viewModel.wishTitleState = wish.value.title
        viewModel.wishDescriptionState = wish.value.description
    } else {
        viewModel.wishTitleState = ""
        viewModel.wishDescriptionState = ""
    }

    Scaffold(
        topBar = { AppBarView(
            if (id != 0L) stringResource(R.string.update_wish)
            else stringResource(R.string.add_wish)
        ) {
            navController.navigateUp()
        } },
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Space()
            WishTextField(
                label = stringResource(R.string.title_txt),
                value = viewModel.wishTitleState,
                onValueChanged = {
                    viewModel.onWishTitleChanged(it)
                }
            )

            Space()
            WishTextField(
                label = stringResource(R.string.desc_txt),
                value = viewModel.wishDescriptionState,
                onValueChanged = {
                    viewModel.onWishDescriptionChanged(it)
                }
            )

            Space()
            Button(
                onClick = {
                    if (viewModel.wishTitleState.isNotEmpty() && viewModel.wishDescriptionState.isNotEmpty()) {
                        if (id != 0L) {
                            // UPDATE WISH
                            viewModel.updateWish(
                                Wish(
                                    id = id,
                                    title = viewModel.wishTitleState.trim(),
                                    description = viewModel.wishDescriptionState.trim()
                                )
                            )
                        } else {
                            // ADD WISH
                            viewModel.addWish(
                                Wish(
                                    title = viewModel.wishTitleState.trim(),
                                    description = viewModel.wishDescriptionState.trim()
                                )
                            )
                            snackMessage.value = "Wish has been created"
                        }
                    } else {
                        snackMessage.value = "Enter fields to create a wish"
                    }
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                        navController.navigateUp()
                    }
                }
            ) {
                Text(
                    text = if (id != 0L) stringResource(R.string.update_wish)
                    else stringResource(R.string.add_wish),
                    fontSize = 18.sp
                )
            }
        }
    }
}