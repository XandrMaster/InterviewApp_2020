package digital.equinox.interviewapp_2020

object Const {

    const val demoUserId = R.string.login
    const val demoPswdId = R.string.password

    object Retrofit {

        const val idPath = "id"
        const val delayQuery = "mocky-delay"

        const val demoId200 = "5e90839533000078c327d859"
        const val demoId401 = "5e90841633000049b527d85e"
        const val demoDelay = 5000 // ms

        const val resultResp = "result"

        object Timeouts {  // sec
            const val readTimeout = 20L
            const val writeTimeout = 20L
            const val connectTimeout = 10L
        }
    }
}