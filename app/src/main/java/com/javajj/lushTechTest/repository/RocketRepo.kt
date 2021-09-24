package com.javajj.lushTechTest.repository

import android.annotation.SuppressLint
import android.util.Log
import com.javajj.lushTechTest.model.db.RocketDao
import com.javajj.lushTechTest.model.rocket.RocketResponse
import com.javajj.lushTechTest.model.network.RocketApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

/**
 * Class is used to communicate with the API and local Room database
 */
class RocketRepo(
    private val rocketDao: RocketDao,
    private val rocketApi: RocketApi
) {

    /**
     * Retrieves data from Api and caches it to local database
     */
    @SuppressLint("LogNotTimber")
    suspend fun getMissions() {
        withContext(Dispatchers.IO) {
            try {
                val rocketData = rocketApi.getAllMissionsAsync().await()
                storeRocketData(RocketResponse(1, rocketData))
            } catch (exception: HttpException) {
                Log.d("HTTP-EX", exception.message())
            }
        }
    }

    /**
     * Store RocketRepo data to local database
     */
    fun storeRocketData(rocketResponse: RocketResponse) {
        rocketDao.insertRockets(rocketResponse)
    }

    /**
     * Listens for changes in the RocketRepo table and reports to any registered
     * ViewModel classes
     */
    val rocketData = rocketDao.getAllRockets()
}

