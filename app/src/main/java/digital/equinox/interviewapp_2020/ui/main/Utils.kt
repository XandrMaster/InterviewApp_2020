package digital.equinox.interviewapp_2020.ui.main

import android.os.Handler
import android.os.Looper

object Utils {

    fun isItMainThread(): Boolean {
        return Looper.myLooper() == Looper.getMainLooper()
    }

    fun runInMainThread(code: () -> Unit) {
        if (isItMainThread()) {
            code()
        } else {
            Handler(Looper.getMainLooper()).post {
                code()
            }
        }
    }
}