package cl.bootcamp.conectarapiretrofit.data

import cl.bootcamp.conectarapiretrofit.model.GamesModel
import cl.bootcamp.conectarapiretrofit.util.Constants.Companion.API_KEY
import cl.bootcamp.conectarapiretrofit.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiGames {

    @GET(ENDPOINT + API_KEY)
    suspend fun getGames(): Response<GamesModel>
}