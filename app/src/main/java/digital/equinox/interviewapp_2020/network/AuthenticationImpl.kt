package digital.equinox.interviewapp_2020.network

import android.content.Context
import digital.equinox.interviewapp_2020.Const.Retrofit.demoDelay
import digital.equinox.interviewapp_2020.Const.Retrofit.demoId200
import digital.equinox.interviewapp_2020.Const.Retrofit.demoId401
import digital.equinox.interviewapp_2020.Const.demoPswdId
import digital.equinox.interviewapp_2020.Const.demoUserId

class AuthenticationImpl(
    private val ctx: Context,
    private val apiManager: ApiManager
) : Authentication {

    override suspend fun tryAuthenticate(username: String, pswd: String): Boolean {
        val demoId = if (checkCreds(username, pswd)) {
            demoId200
        } else {
            demoId401
        }

        val response = apiManager.login(demoId, demoDelay)
        return response.isSuccessful
    }

    private fun checkCreds(username: String, pswd: String): Boolean {
        return username == ctx.getString(demoUserId)
                && pswd == ctx.getString(demoPswdId)
    }
}