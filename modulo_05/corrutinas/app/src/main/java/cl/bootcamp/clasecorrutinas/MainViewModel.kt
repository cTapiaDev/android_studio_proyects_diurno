package cl.bootcamp.clasecorrutinas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")

    var isLoading by mutableStateOf(false)
        private set

    fun fetchData() {
        viewModelScope.launch {
            try {
                isLoading = true
                val result = withContext(Dispatchers.IO) {
                    delay(5000)
                    "Respuesta de la API"
                }
                resultState = result
            } catch (e: Exception) {
                println("error: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

    fun bloqueoApp() {
        Thread.sleep(5000)
    }
}