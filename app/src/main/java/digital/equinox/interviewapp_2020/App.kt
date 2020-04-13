package digital.equinox.interviewapp_2020

import android.app.Application
import digital.equinox.interviewapp_2020.di.AppInjectionModules
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.conf.ConfigurableKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class App : Application(), KodeinAware {

    override val kodein = ConfigurableKodein()

    override fun onCreate() {
        super.onCreate()

        setupDI()
    }

    private fun setupDI() {
        kodein.apply {
            mutable = true

            clear()

            addImport(AppInjectionModules.module)

            addImport(Kodein.Module(javaClass.name) {
                bind() from singleton { this@App.contentResolver }
                bind() from singleton { this@App }
            })
        }
    }
}