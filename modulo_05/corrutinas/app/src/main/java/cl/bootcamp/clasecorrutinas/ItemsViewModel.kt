package cl.bootcamp.clasecorrutinas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemsViewModel: ViewModel() {

    // Lista generada con Flow
    private val _lista: MutableStateFlow<List<ItemsModel>> = MutableStateFlow(emptyList())
    val lista = _lista

    var itemList = mutableStateListOf(ItemsModel())

    var resultState by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    fun fetchData() {
        viewModelScope.launch {
            try {
                isLoading = true
                llamarApi()
            } catch (e: Exception) {
                println("Error: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

    private suspend fun llamarApi() {
        val result = withContext(Dispatchers.IO) {
            delay(5000)
            listOf(
                ItemsModel(1, "Elemento 1"),
                ItemsModel(2, "Elemento 2"),
                ItemsModel(3, "Elemento 3"),
                ItemsModel(4, "Elemento 4"),
                ItemsModel(5, "Elemento 5"),
                ItemsModel(6, "Elemento 6"),
                ItemsModel(7, "Elemento 7"),
                ItemsModel(8, "Elemento 8"),
                ItemsModel(9, "Elemento 9"),
                ItemsModel(10, "Elemento 10"),
                ItemsModel(11, "Elemento 11"),
                ItemsModel(12, "Elemento 12"),
                ItemsModel(13, "Elemento 13"),
                ItemsModel(14, "Elemento 14"),
                ItemsModel(15, "Elemento 15"),
                ItemsModel(16, "Elemento 16"),
                ItemsModel(17, "Elemento 17"),
                ItemsModel(18, "Elemento 18"),
                ItemsModel(19, "Elemento 19"),
                ItemsModel(20, "Elemento 20"),
                ItemsModel(1, "Elemento 1"),
                ItemsModel(2, "Elemento 2"),
                ItemsModel(3, "Elemento 3"),
                ItemsModel(4, "Elemento 4"),
                ItemsModel(5, "Elemento 5"),
                ItemsModel(6, "Elemento 6"),
                ItemsModel(7, "Elemento 7"),
                ItemsModel(8, "Elemento 8"),
                ItemsModel(9, "Elemento 9"),
                ItemsModel(10, "Elemento 10"),
                ItemsModel(11, "Elemento 11"),
                ItemsModel(12, "Elemento 12"),
                ItemsModel(13, "Elemento 13"),
                ItemsModel(14, "Elemento 14"),
                ItemsModel(15, "Elemento 15"),
                ItemsModel(16, "Elemento 16"),
                ItemsModel(17, "Elemento 17"),
                ItemsModel(18, "Elemento 18"),
                ItemsModel(19, "Elemento 19"),
                ItemsModel(20, "Elemento 20"),
                ItemsModel(1, "Elemento 1"),
                ItemsModel(2, "Elemento 2"),
                ItemsModel(3, "Elemento 3"),
                ItemsModel(4, "Elemento 4"),
                ItemsModel(5, "Elemento 5"),
                ItemsModel(6, "Elemento 6"),
                ItemsModel(7, "Elemento 7"),
                ItemsModel(8, "Elemento 8"),
                ItemsModel(9, "Elemento 9"),
                ItemsModel(10, "Elemento 10"),
                ItemsModel(11, "Elemento 11"),
                ItemsModel(12, "Elemento 12"),
                ItemsModel(13, "Elemento 13"),
                ItemsModel(14, "Elemento 14"),
                ItemsModel(15, "Elemento 15"),
                ItemsModel(16, "Elemento 16"),
                ItemsModel(17, "Elemento 17"),
                ItemsModel(18, "Elemento 18"),
                ItemsModel(19, "Elemento 19"),
                ItemsModel(20, "Elemento 20")
            )
        }
        itemList.addAll(result)
        _lista.value = result
    }


}