package de.hpi.android

import androidx.multidex.MultiDexApplication
import com.jakewharton.threetenabp.AndroidThreeTen
import de.hpi.android.core.presentation.base.appContext
import timber.log.Timber

class App : MultiDexApplication() {
    override fun onCreate() {
        appContext = this
        super.onCreate()

        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
        AndroidThreeTen.init(this)
    }
}
