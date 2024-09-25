package cl.bootcamp.appwishlist.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
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
