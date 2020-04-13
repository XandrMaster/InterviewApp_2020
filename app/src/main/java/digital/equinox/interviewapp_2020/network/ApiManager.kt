package digital.equinox.interviewapp_2020.network

import digital.equinox.interviewapp_2020.network.model.LoginResp
import retrofit2.Response

class ApiManager(private val api: Api) {

    /**
     *
     * @param id
     * @param delay - ms
     * @return
     */
    suspend fun login(id: String, delay: Int = -1): Response<LoginResp> {

        return if (delay >= 0) {
            api.login(id, getStrDelay(delay)).await()
        } else {
            api.login(id).await()
        }
    }

    private fun getStrDelay(delay: Int): String {
        if (delay >= 0) {
            return "${delay}ms"
        }
        return ""
    }
}