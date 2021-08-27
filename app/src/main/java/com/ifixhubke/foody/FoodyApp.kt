package com.ifixhubke.foody

import android.app.Application
import timber.log.Timber

class FoodyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}