package cl.bootcamp.appwishlist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name="wish-title")
    val title: String = "",
    @ColumnInfo(name="wish-desc")
    val description: String = ""
)

object DummyWish {
    val wishList = listOf(
        Wish(title = "Google Watch 2", description = "Un reloj de Google"),
        Wish(title = "Oculus Quest 2", description = "set de VR para juegos"),
        Wish(title = "Alas de Sangre", description = "Un nuevo best seller"),
        Wish(title = "Play 5 Pro", description = "Nueva consola de juegos"),
    )
}
