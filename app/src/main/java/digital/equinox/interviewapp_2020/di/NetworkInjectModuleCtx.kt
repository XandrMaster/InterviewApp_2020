package digital.equinox.interviewapp_2020.di

import digital.equinox.interviewapp_2020.network.NetworkInfo
import digital.equinox.interviewapp_2020.network.NetworkInfoImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

object NetworkInjectModuleCtx {

    val module = Kodein.Module(NetworkInjectModuleCtx.javaClass.name) {

        bind<NetworkInfo>() with singleton {
            NetworkInfoImpl(instance())
        }
    }
}