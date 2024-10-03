package cl.bootcamp.appintegrador

import android.arch.core.executor.testing.InstantTaskExecutorRule
import cl.bootcamp.appintegrador.datasource.RestDataSource
import cl.bootcamp.appintegrador.model.User
import cl.bootcamp.appintegrador.model.UserDao
import cl.bootcamp.appintegrador.repository.UserRepositoryImp
import cl.bootcamp.appintegrador.util.Constants.Companion.ENDPOINT_LOCATION
import cl.bootcamp.appintegrador.util.Constants.Companion.ENDPOINT_NAME
import cl.bootcamp.appintegrador.util.Constants.Companion.ENDPOINT_PICTURE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.StandardCharsets

private val user1 = User("Slim", "Shady", "Detroit", "http://...")
private val user2 = User("Gaby", "Ferreyra", "Chicago", "http://...")

class UserRepositoryTest {
    private val mockWebServer = MockWebServer().apply {
        url("/")
        dispatcher = myDispatcher
    }

    private val restDataSource = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RestDataSource::class.java)

    private val newsRepository = UserRepositoryImp(restDataSource, MockUserDao())


    @get:Rule
    val rule = InstantTaskExecutorRule()

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `Verificar si obtenemos correctamente los usuarios de la DB`() = runBlocking {
        val users = newsRepository.getAllUser().first()
        assertEquals(2, users.size)
    }

    @Test
    fun `Eliminar un usuario`() = runBlocking {
        newsRepository.deleteUser(user1)

        val users = newsRepository.getAllUser().first()
        assertEquals(1, users.size)
    }

    @Test
    fun `Se crean correctamente los datos de un nuevo usuario`() = runBlocking {
        val newUser = newsRepository.getNewUser()
        val users = newsRepository.getAllUser().first()
        assertEquals(3, users.size)
        assertEquals(newUser.name, "Andy")
        assertEquals(newUser.lastName, "Schmitt")
        assertEquals(newUser.city, "Čajetina")
        //assertEquals(newUser.thumbnail, "https://randomuser.me/api/portraits/thumb/men/92.jpg")
        assert(newUser.thumbnail.contains("thumb/men/92.jpg"))
    }
}

class MockUserDao: UserDao {
    private val users = MutableStateFlow<List<User>>(listOf(user1, user2))

    override fun insert(user: User) {
        users.value = users.value.toMutableList().apply { add(user) }
    }

    override fun getAll(): Flow<List<User>> = users

    override fun delete(user: User) {
        users.value = users.value.toMutableList().apply { remove(user) }
    }

}

val myDispatcher: Dispatcher = object : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            "/$ENDPOINT_NAME" -> MockResponse().apply { addResponse("api_name.json") }
            "/$ENDPOINT_LOCATION" -> MockResponse().apply { addResponse("api_location.json") }
            "/$ENDPOINT_PICTURE" -> MockResponse().apply { addResponse("api_picture.json") }
            else -> MockResponse().setResponseCode(404)
        }
    }
}

fun MockResponse.addResponse(filePath: String): MockResponse {
    val inputStream = javaClass.classLoader?.getResourceAsStream(filePath)
    val source = inputStream?.source()?.buffer()
    source?.let {
        setResponseCode(200)
        setBody(it.readString(StandardCharsets.UTF_8))
    }
    return this
}