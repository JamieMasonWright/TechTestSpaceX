package com.javajj.lushTechTest.model.network

import com.javajj.lushTechTest.model.rocket.Rocket
import com.javajj.lushTechTest.model.network.NetworkConstants.ENDPOINT
import kotlinx.coroutines.Deferred
import retrofit2.http.GET


interface  RocketApi {

    @GET(ENDPOINT)
    fun getAllMissionsAsync() : Deferred<List<Rocket>>
}