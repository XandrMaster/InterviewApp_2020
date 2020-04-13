package digital.equinox.interviewapp_2020.app.preferences

interface AppPreferences {

    fun isLogged(): Boolean

    fun setLogged(logged: Boolean)
}