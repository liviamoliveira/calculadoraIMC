package dev.estudos.calculadoraimc

import android.app.Application
import dev.estudos.calculadoraimc.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class TheApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        configureKoin()
        configureTimber()
    }

    private fun configureKoin() {
        startKoin {
            androidContext(this@TheApplication)
            modules(
                AppModule.getModules()
            )
        }
    }

    private fun configureTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}