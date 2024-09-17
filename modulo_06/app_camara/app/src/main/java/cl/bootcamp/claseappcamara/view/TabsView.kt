package cl.bootcamp.claseappcamara.view

import android.graphics.Camera
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cl.bootcamp.claseappcamara.viewModel.ScannerViewModel

@Composable
fun TabsView(viewModel: ScannerViewModel, paddingValues: PaddingValues) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Galería", "Cámara", "Colección")

    Column(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        TabRow(
            selectedTabIndex = selectedTab,
            contentColor = Color.Black,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTab])
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(text = title) }
                )
            }
        }
        when (selectedTab) {
            0 -> GalleryView(viewModel).apply { viewModel.cleanText() }
            1 -> CameraView(viewModel).apply { viewModel.cleanText() }
            2 -> CollectionView()
        }
    }
}