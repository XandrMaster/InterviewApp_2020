package digital.equinox.interviewapp_2020.network

import digital.equinox.interviewapp_2020.Const.Retrofit.delayQuery
import digital.equinox.interviewapp_2020.Const.Retrofit.idPath
import digital.equinox.interviewapp_2020.network.model.LoginResp
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @POST("{$idPath}/")
    fun login(@Path(idPath) id: String): Deferred<Response<LoginResp>>

    @POST("{$idPath}/")
    fun login(@Path(idPath) id: String, @Query(delayQuery) delay: String): Deferred<Response<LoginResp>>
}