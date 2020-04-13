package digital.equinox.interviewapp_2020.ui.main.viewmodels

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import digital.equinox.interviewapp_2020.app.preferences.AppPreferences
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainViewModel(app: Application) : AndroidViewModel(app), KodeinAware {

    override val kodein by kodein(app.applicationContext)

    private val preferences: AppPreferences by instance()

    private val _logOutResult = MutableLiveData(false)
    val logOutResult: LiveData<Boolean> = _logOutResult

    private val _toCamera = MutableLiveData(false)
    val toCamera: LiveData<Boolean> = _toCamera

    fun isLogged(): Boolean {
        return preferences.isLogged()
    }

    fun logOut(view: View) {
        preferences.setLogged(false)
        _logOutResult.value = true
    }

    fun camera(view: View) {
        _toCamera.value = true
    }
}
