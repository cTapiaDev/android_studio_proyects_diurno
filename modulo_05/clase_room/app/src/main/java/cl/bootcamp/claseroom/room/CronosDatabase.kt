package cl.bootcamp.claseroom.room

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.bootcamp.claseroom.model.Cronos

@Database(entities = [Cronos::class], version = 1, exportSchema = false)
abstract class CronosDatabase: RoomDatabase() {
    abstract fun cronosDao(): CronosDataBaseDao
}