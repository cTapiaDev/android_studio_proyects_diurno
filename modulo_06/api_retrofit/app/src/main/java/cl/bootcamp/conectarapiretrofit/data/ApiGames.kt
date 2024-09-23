package cl.bootcamp.conectarapiretrofit.data

import cl.bootcamp.conectarapiretrofit.model.GamesModel
import cl.bootcamp.conectarapiretrofit.model.SingleGameModel
import cl.bootcamp.conectarapiretrofit.util.Constants.Companion.API_KEY
import cl.bootcamp.conectarapiretrofit.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiGames {

    @GET(ENDPOINT + API_KEY)
    suspend fun getGames(): Response<GamesModel>

    @GET("${ENDPOINT}/{name}${API_KEY}")
    suspend fun getGameByName(@Path(value = "name") name: String): Response<SingleGameModel>

    @GET("${ENDPOINT}/{id}${API_KEY}")
    suspend fun getGameById(@Path(value = "id") id: Int): Response<SingleGameModel>

    @GET(ENDPOINT + API_KEY)
    suspend fun getGamesPaging(@Query("page") page: Int, @Query("page_size") pageSize: Int): GamesModel
}