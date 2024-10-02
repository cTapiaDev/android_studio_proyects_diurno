package cl.bootcamp.appintegrador.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bootcamp.appintegrador.model.User
import cl.bootcamp.appintegrador.model.UserDao

@Database(
    entities = [User::class],
    version = 1
)
abstract class DbDataSource: RoomDatabase() {
    abstract fun userDao(): UserDao
}