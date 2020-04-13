package digital.equinox.interviewapp_2020.network.model

import com.google.gson.annotations.SerializedName
import digital.equinox.interviewapp_2020.Const.Retrofit.resultResp

class LoginResp {

    @SerializedName(resultResp)
    val result: ResultResp? = null

    enum class ResultResp {
        ok,
        unauthorized
    }
}
