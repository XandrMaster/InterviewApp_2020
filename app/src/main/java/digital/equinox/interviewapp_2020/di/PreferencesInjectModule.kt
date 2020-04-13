package digital.equinox.interviewapp_2020.di

import androidx.preference.PreferenceManager
import digital.equinox.interviewapp_2020.app.preferences.AppPreferences
import digital.equinox.interviewapp_2020.app.preferences.AppPreferencesImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

object PreferencesInjectModule {

    val module = Kodein.Module(PreferencesInjectModule.javaClass.name) {

        bind() from singleton {
            PreferenceManager.getDefaultSharedPreferences(instance())
        }

        bind<AppPreferences>() with singleton {
            AppPreferencesImpl(instance())
        }
    }
}