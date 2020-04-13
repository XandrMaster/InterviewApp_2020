package digital.equinox.interviewapp_2020.ui.main.viewmodels

import android.app.Application
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import digital.equinox.interviewapp_2020.Const.demoPswdId
import digital.equinox.interviewapp_2020.Const.demoUserId
import digital.equinox.interviewapp_2020.app.preferences.AppPreferences
import digital.equinox.interviewapp_2020.network.Authentication
import digital.equinox.interviewapp_2020.network.NetworkInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginViewModel(app: Application) : AndroidViewModel(app), KodeinAware {

    override val kodein by kodein(app.applicationContext)

    val username by lazy {
        ObservableField<String>(
            app.applicationContext.getString(
                demoUserId
            )
        )
    }

    val pswd by lazy {
        ObservableField<String>(
            app.applicationContext.getString(
                demoPswdId
            )
        )
    }

    val loginBtnEnable by lazy { ObservableBoolean(true) }

    private val preferences: AppPreferences by instance()
    private val authentication: Authentication by instance()
    private val networkInfo: NetworkInfo by instance()

    private val _loginResult = MutableLiveData(false)
    val loginResult: LiveData<Boolean> = _loginResult

    private val _noNetwork = MutableLiveData(false)
    val noNetwork: LiveData<Boolean> = _noNetwork

    private val _progress = MutableLiveData(false)
    val showProgress: LiveData<Boolean> = _progress

    fun login(view: View) {
        viewModelScope.launch(Dispatchers.IO) {
            loginBtnEnable.set(false)
            _progress.postValue(true)
            if (networkInfo.isNetworkConnected()) {
                // TODO: 4/13/20 check null username.get() ...
                val result = authentication.tryAuthenticate(username.get()!!, pswd.get()!!)
                preferences.setLogged(result)
                _loginResult.postValue(result)
            } else {
                _noNetwork.postValue(true)
            }
            _progress.postValue(false)
            loginBtnEnable.set(true)
        }
    }
}
