package cl.bootcamp.approomimage.view

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cl.bootcamp.approomimage.viewModel.ImagesViewModel
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, viewModel: ImagesViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text( text = "Image Room") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("AddPhotoView")
            }) {
                Icon(Icons.Default.Add, contentDescription = "")
            }
        }
    ) {
        ContentHomeView(it, viewModel)
    }
}

@Composable
fun ContentHomeView(pad: PaddingValues, viewModel: ImagesViewModel) {
    val images by viewModel.imageList.collectAsState()

    Column(
        modifier = Modifier
            .padding(pad)
    ) {
        LazyColumn {
            items(images) { item ->
                // Text(text = item.ruta )
                PhotoView(item.ruta)
            }
        }
    }
}

@Composable
fun PhotoView(imagePath: String) {
    val bitmap = remember {
        val file = File(imagePath)
        BitmapFactory.decodeFile(file.absolutePath)
    }
    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
            .padding(15.dp)
            .shadow(10.dp, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Fit
    )
}