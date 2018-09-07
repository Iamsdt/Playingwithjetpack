package com.iamsdt.playingwithjetpack

import android.app.Application
import com.iamsdt.playingwithjetpack.base.di.dbModule
import com.iamsdt.playingwithjetpack.base.di.networkModule
import com.iamsdt.playingwithjetpack.base.ext.DebugLogTree
import com.rohitss.uceh.UCEHandler
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class MyApp:Application(){

    override fun onCreate() {
        super.onCreate()

        //this app will always run in debug mode

        //timber
        Timber.plant(DebugLogTree())

        //crash offline crash receiver
        UCEHandler.Builder(this)
                .setTrackActivitiesEnabled(true)
                .setBackgroundModeEnabled(true)
                .build()

        //start koin
        startKoin(this, listOf(dbModule, networkModule))
    }

}