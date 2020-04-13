package digital.equinox.interviewapp_2020.di.nocontext

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import digital.equinox.interviewapp_2020.BuildConfig
import digital.equinox.interviewapp_2020.Const.Retrofit.Timeouts.connectTimeout
import digital.equinox.interviewapp_2020.Const.Retrofit.Timeouts.readTimeout
import digital.equinox.interviewapp_2020.Const.Retrofit.Timeouts.writeTimeout
import digital.equinox.interviewapp_2020.network.Api
import digital.equinox.interviewapp_2020.network.ApiManager
import digital.equinox.interviewapp_2020.network.Authentication
import digital.equinox.interviewapp_2020.network.AuthenticationImpl
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkInjectModule {

    val module = Kodein.Module(NetworkInjectModule.javaClass.name) {

        bind() from singleton {
            GsonBuilder().create()
        }

        bind() from singleton {
            GsonConverterFactory.create(instance())
        }

        bind() from singleton {
            CoroutineCallAdapterFactory.invoke()
        }

        bind() from singleton {
            OkHttpClient.Builder()
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .build()
        }

        bind() from singleton {
            Retrofit.Builder()
                .baseUrl(BuildConfig.API_ROOT)
                .client(instance())
                .addConverterFactory(instance())
                .addCallAdapterFactory(instance())
                .build()
        }

        bind() from singleton {
            instance<Retrofit>().create(Api::class.java)
        }

        bind() from singleton {
            ApiManager(instance())
        }

        bind<Authentication>() with singleton {
            AuthenticationImpl(instance(), instance())
        }
    }
}