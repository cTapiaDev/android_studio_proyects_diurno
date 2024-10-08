package cl.bootcamp.pruebacertificacionejemplo.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.bootcamp.pruebacertificacionejemplo.model.User
import cl.bootcamp.pruebacertificacionejemplo.repository.WalletRepository
import cl.bootcamp.pruebacertificacionejemplo.state.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class WalletViewModel @Inject constructor(
    private val repo: WalletRepository
): ViewModel() {

    var state by mutableStateOf(UserState())
        private set

    val users: Flow<List<User>> by lazy {
        repo.getAllUserRoom()
    }

    fun getAllAPI() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repo.getAllUserAPI()
                Log.d("USERS", repo.getAllUserAPI().toString())
            }
        }
    }

    fun getUserById(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repo.getUserById(id)
                state = state.copy(
                    nombre = result.nombre,
                    pais = result.pais,
                    imagenLink = result.imagenLink,
                    cuenta = result.cuenta,
                    saldo = result.saldo,
                    depositos = result.depositos
                )
            }
        }
    }

    fun clean() {
        state = state.copy(
            nombre = "",
            pais = "",
            imagenLink = "",
            cuenta = "",
            saldo = 0.0,
            depositos = false
        )
    }

}