package com.kristal.analytics

import android.app.Application

/**
 * Created by Dwi_Ari on 11/2/17.
 */

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AnalyticsEvent.install(this)
    }
}