package cl.bootcamp.appwishlist.room

import android.content.Context
import androidx.room.Room
import cl.bootcamp.appwishlist.repository.WishRepository

object Graph {

    lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(
            context,
            WishDatabase::class.java,
            "wishList.db"
        ).build()
    }

}