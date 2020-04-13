package digital.equinox.interviewapp_2020.app.preferences

import android.content.SharedPreferences

class AppPreferencesImpl(private val preferences: SharedPreferences) : AppPreferences {

    private val IS_LOGGED = "is_logged"

    override fun isLogged(): Boolean {
        return preferences.getBoolean(IS_LOGGED, false)
    }

    override fun setLogged(isLogged: Boolean) {

        preferences.edit().apply {
            putBoolean(IS_LOGGED, isLogged)
        }.apply()
    }
}