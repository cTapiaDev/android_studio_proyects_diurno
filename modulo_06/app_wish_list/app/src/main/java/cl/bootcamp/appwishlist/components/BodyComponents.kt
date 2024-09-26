package cl.bootcamp.appwishlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cl.bootcamp.appwishlist.model.Wish

@Composable
fun WishItem(wish: Wish, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 8.dp, 8.dp, 0.dp)
            .clickable {
                onClick()
            },
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)
        }
    }
}

@Composable
fun Space(num: Dp = 10.dp, opt: Boolean = false) {
    if (!opt) Spacer(modifier = Modifier.height(num))
    else Spacer(modifier = Modifier.width(num))
}

@Composable
fun WishTextField(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text( text = label, color = Color.Black) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            cursorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black
        )
    )
}