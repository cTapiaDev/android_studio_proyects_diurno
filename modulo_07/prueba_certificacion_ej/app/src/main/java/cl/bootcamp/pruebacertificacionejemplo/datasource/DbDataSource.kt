package cl.bootcamp.pruebacertificacionejemplo.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bootcamp.pruebacertificacionejemplo.model.User
import cl.bootcamp.pruebacertificacionejemplo.model.UserDao

@Database(
    entities = [User::class],
    version = 1
)
abstract class DbDataSource: RoomDatabase() {
    abstract fun userDao(): UserDao
}