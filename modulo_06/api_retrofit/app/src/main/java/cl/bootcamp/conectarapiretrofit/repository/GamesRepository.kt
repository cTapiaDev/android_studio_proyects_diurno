package cl.bootcamp.conectarapiretrofit.repository

import cl.bootcamp.conectarapiretrofit.data.ApiGames
import cl.bootcamp.conectarapiretrofit.model.GameList
import cl.bootcamp.conectarapiretrofit.model.SingleGameModel
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

    suspend fun getGameById(id: Int): SingleGameModel? {
        val response = apiGames.getGameById(id)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

}