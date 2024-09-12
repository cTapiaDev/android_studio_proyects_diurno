package cl.bootcamp.conectarapiretrofit.repository

import cl.bootcamp.conectarapiretrofit.data.ApiGames
import cl.bootcamp.conectarapiretrofit.model.GameList
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: ApiGames) {

    suspend fun getGames(): List<GameList>? {
        val response = apiGames.getGames()
        if (response.isSuccessful) {
            return response.body()?.results
        }
        return null
    }

}