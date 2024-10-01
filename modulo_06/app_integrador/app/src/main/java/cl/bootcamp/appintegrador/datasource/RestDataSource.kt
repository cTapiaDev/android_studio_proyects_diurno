package cl.bootcamp.appintegrador.datasource

import cl.bootcamp.appintegrador.model.ApiResponse
import cl.bootcamp.appintegrador.util.Constants.Companion.ENDPOINT_LOCATION
import cl.bootcamp.appintegrador.util.Constants.Companion.ENDPOINT_NAME
import cl.bootcamp.appintegrador.util.Constants.Companion.ENDPOINT_PICTURE
import retrofit2.http.GET

interface RestDataSource {

    @GET(ENDPOINT_NAME)
    suspend fun getUserName(): ApiResponse

    @GET(ENDPOINT_PICTURE)
    suspend fun getUserPicture(): ApiResponse

    @GET(ENDPOINT_LOCATION)
    suspend fun getUserLocation(): ApiResponse

}