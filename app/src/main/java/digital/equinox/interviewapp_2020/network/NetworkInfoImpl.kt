package digital.equinox.interviewapp_2020.network

import android.content.Context
import android.net.ConnectivityManager

class NetworkInfoImpl(private val context: Context) : NetworkInfo {

    override fun isNetworkConnected(): Boolean {

        val connManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connManager == null) {
            throw NullPointerException(" CONNECTIVITY_SERVICE is null ")
        } else {
            // TODO: 4/10/20  Deprecated approach
            val activeNetworkInfo = connManager.activeNetworkInfo
            return activeNetworkInfo?.isConnected ?: false
        }

        return false
    }
}
