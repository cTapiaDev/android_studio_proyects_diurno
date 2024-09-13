package cl.bootcamp.conectarapiretrofit.state

data class GameState(
    val name: String = "",
    val description_raw: String = "",
    val metacritic: Int = 111,
    val website: String = "",
    val background_image: String = ""
)
