package digital.equinox.interviewapp_2020.di

import digital.equinox.interviewapp_2020.di.nocontext.NetworkInjectModule
import org.kodein.di.Kodein

object AppInjectionModules {

    val module = Kodein.Module(AppInjectionModules.javaClass.name) {
        import(NetworkInjectModule.module)
        // modules with Context
        import(NetworkInjectModuleCtx.module)
        import(PreferencesInjectModule.module)
    }
}