package cl.bootcamp.appwishlist.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.bootcamp.appwishlist.R
import cl.bootcamp.appwishlist.components.AppBarView
import cl.bootcamp.appwishlist.components.Space
import cl.bootcamp.appwishlist.components.WishTextField
import cl.bootcamp.appwishlist.viewModel.WishViewModel

@Composable
fun AddEditDetailsView(
    id: Long,
    navController: NavController,
    viewModel: WishViewModel
) {
    Scaffold(
        topBar = { AppBarView(
            if (id != 0L) stringResource(R.string.update_wish)
            else stringResource(R.string.add_wish)
        ) {
            navController.navigateUp()
        } }
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
                        // AQUI VAMOS A TENER LA MODIFICACION - UPDATE WISH
                    } else {
                        // AQUI VAMOS A AGREGAR UN DATO NUEVO - ADD WISH
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