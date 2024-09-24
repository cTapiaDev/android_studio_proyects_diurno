package cl.bootcamp.approomimage.room

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bootcamp.approomimage.model.ImagesModel

@Database(entities = [ImagesModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun imageDao(): ImagesDao
}