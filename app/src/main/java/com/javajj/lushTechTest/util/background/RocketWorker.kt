package com.javajj.lushTechTest.util.background

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.javajj.lushTechTest.repository.RocketRepo
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Used by WorkManager to schedule work to be completed in the background
 */
class RocketWorker (appContext:Context, parameters: WorkerParameters) :
    CoroutineWorker(appContext, parameters), KoinComponent {

    private val rocketRepo: RocketRepo by inject()

    companion object {
        const val WORK_LOCATION = "com.javajj.lushTechTest.util.background.RocketWorker"
    }

    override suspend fun doWork(): Result {
        try {
            rocketRepo.getMissions()
        } catch (e: Exception) {
            return Result.retry()
        }
        return Result.success()
    }
}