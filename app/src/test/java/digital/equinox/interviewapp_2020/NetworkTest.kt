package digital.equinox.interviewapp_2020

import digital.equinox.interviewapp_2020.Const.Retrofit.demoDelay
import digital.equinox.interviewapp_2020.Const.Retrofit.demoId200
import digital.equinox.interviewapp_2020.Const.Retrofit.demoId401
import digital.equinox.interviewapp_2020.di.nocontext.NetworkInjectModule
import digital.equinox.interviewapp_2020.network.ApiManager
import digital.equinox.interviewapp_2020.network.model.LoginResp
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import java.net.HttpURLConnection

class NetworkTest {

    private val kodein = Kodein {
        import(NetworkInjectModule.module)
    }

    private val apiManager by kodein.instance<ApiManager>()

    @Test
    fun loginTest() = runBlocking {
        val response = apiManager.login(demoId200)
        Assert.assertTrue(response.isSuccessful)
        val responseBody = response.body()
        Assert.assertNotNull(responseBody)
        Assert.assertNotNull(responseBody!!.result)
        Assert.assertEquals(LoginResp.ResultResp.ok, responseBody.result)
    }

    @Test
    fun loginErrorTest() = runBlocking {
        val response = apiManager.login(demoId401)
        Assert.assertFalse(response.isSuccessful)
        Assert.assertEquals(response.code(), HttpURLConnection.HTTP_UNAUTHORIZED)
        val errorBody = response.errorBody()
        Assert.assertNotNull(errorBody)
        val errorBodyStr = errorBody!!.string()
        Assert.assertTrue(errorBodyStr.isNotBlank())
    }

    @Test
    fun loginWithDelayTest() = runBlocking {
        val response = apiManager.login(demoId200, demoDelay)
        Assert.assertTrue(response.isSuccessful)
        val responseBody = response.body()
        Assert.assertNotNull(responseBody)
        Assert.assertNotNull(responseBody!!.result)
        Assert.assertEquals(LoginResp.ResultResp.ok, responseBody.result)
    }
}