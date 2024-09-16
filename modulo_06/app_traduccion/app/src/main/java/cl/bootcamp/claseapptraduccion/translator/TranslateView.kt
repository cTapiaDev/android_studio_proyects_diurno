package cl.bootcamp.claseapptraduccion.translator

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun TranslateView(paddingValues: PaddingValues, viewModel: TranslateViewModel) {

    val state = viewModel.state
    val context = LocalContext.current
    val languageOptions = viewModel.languageOptions
    val itemSelection = viewModel.itemSelection

    val keyboardController = LocalSoftwareKeyboardController.current

    var indexSource by remember { mutableStateOf(0) }
    var indexTarget by remember { mutableStateOf(1) }
    var expandedSource by remember { mutableStateOf(false) }
    var expandedTarget by remember { mutableStateOf(false) }
    var selectedSourceLang by remember { mutableStateOf(languageOptions[0]) }
    var selectedTargetLang by remember { mutableStateOf(languageOptions[1]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            DropdownLang(
                itemSelection = itemSelection,
                selectedIndex = indexSource,
                expand = expandedSource,
                onClickExpanded = { expandedSource = true },
                onClickDismiss = { expandedSource = false },
                onClickItem = {index ->
                    indexSource = index
                    selectedSourceLang = languageOptions[index]
                    expandedSource = true
                }
            )
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowForward, 
                contentDescription = "",
                modifier = Modifier
                    .padding(
                        start = 15.dp,
                        end = 15.dp
                    )
            )

            DropdownLang(
                itemSelection = itemSelection,
                selectedIndex = indexTarget,
                expand = expandedTarget,
                onClickExpanded = { expandedTarget = true },
                onClickDismiss = { expandedTarget = false },
                onClickItem = { index ->
                    indexTarget = index
                    selectedTargetLang = languageOptions[index]
                    expandedTarget = true
                }
            )

        }

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = state.textToTranslate,
            onValueChange = { viewModel.onValue(it) },
            label = { Text(text = "Escribe...") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    viewModel.onTranslate(
                        state.textToTranslate,
                        context,
                        selectedSourceLang,
                        selectedTargetLang
                    )
                }
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
        )

        if (state.isDownloading) {
            CircularProgressIndicator()
            Text(text = "Descargando modelo, espere un momento...")
        } else {
            OutlinedTextField(
                value = state.translateText,
                onValueChange = {},
                label = { Text(text = "Tu texto traducido...") },
                readOnly = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }
    }

}