package cl.bootcamp.pruebacertificacionejemplo.repository

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import cl.bootcamp.pruebacertificacionejemplo.datasource.RestDataSource
import cl.bootcamp.pruebacertificacionejemplo.model.User
import cl.bootcamp.pruebacertificacionejemplo.model.UserDao
import cl.bootcamp.pruebacertificacionejemplo.model.UserWallet
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface WalletRepository {
    suspend fun getUserById(id: Int): UserWallet
    suspend fun getAllUserAPI(): ArrayList<UserWallet>
    fun getAllUserRoom(): Flow<List<User>>
}

class WalletRepositoryImp @Inject constructor(
    private val dataSource: RestDataSource,
    private val userDao: UserDao
): WalletRepository {
    override suspend fun getUserById(id: Int): UserWallet {
        val data = dataSource.getUserById(id).body()!!
        val user = UserWallet(
            data.id,
            data.nombre,
            data.pais,
            data.imagenLink,
            data.cuenta,
            data.saldo,
            data.depositos
        )
        return user
    }

    override suspend fun getAllUserAPI(): ArrayList<UserWallet> {
        val data = dataSource.getUsers()
        data.forEach {
            val user = User(
                it.id,
                it.nombre,
                it.pais,
                it.imagenLink,
                it.cuenta,
                it.saldo,
                it.depositos
            )
            userDao.insert(user)
        }
        return ArrayList(data)
    }

    override fun getAllUserRoom(): Flow<List<User>> = userDao.getAll()

}