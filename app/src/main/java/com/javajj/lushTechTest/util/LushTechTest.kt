package com.javajj.lushTechTest.util

import android.app.Application
import androidx.work.*
import com.javajj.lushTechTest.di.*
import com.javajj.lushTechTest.util.background.RocketWorker
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import java.util.concurrent.TimeUnit

class LushTechTest : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin()
        startWorkManager()
    }

    private fun startKoin(){
        startKoin {
            androidContext(this@LushTechTest)
            androidLogger(Level.ERROR)
            modules(netModule, apiModule, databaseModule, repoModule, viewModelModule)
        }
    }

    private fun startWorkManager(){
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresCharging(false)
            .setRequiresBatteryNotLow(true)
            .setRequiresStorageNotLow(false)
            .build()

        //Set the frequency at which the job should be executed
        val repeatingRequest = PeriodicWorkRequestBuilder<RocketWorker>(1, TimeUnit.HOURS)
            //Add the device constraints
            .setConstraints(constraints)
            .build()

        //Schedule the work to be completed
        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            RocketWorker.WORK_LOCATION,
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest
        )
    }
}