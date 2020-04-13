package digital.equinox.interviewapp_2020.network

interface Authentication {

    suspend fun tryAuthenticate(username: String, pswd: String): Boolean
}