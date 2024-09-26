package cl.bootcamp.appwishlist.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import cl.bootcamp.appwishlist.model.Wish
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWish(wishEntity: Wish)

    @Query("SELECT * FROM `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Query("SELECT * FROM `wish-table` WHERE id = :id")
    abstract fun getAWishById(id: Long): Flow<Wish>

    @Update
    abstract suspend fun updateAWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteAWish(wishEntity: Wish)
}