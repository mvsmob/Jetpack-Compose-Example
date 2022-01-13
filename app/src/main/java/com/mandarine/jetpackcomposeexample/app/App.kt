package com.mandarine.jetpackcomposeexample.app

import android.app.Application
import com.mandarine.jetpackcomposeexample.di.appModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            modules(listOf(appModule))
        }
    }
}