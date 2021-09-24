package com.javajj.lushTechTest.repository

import com.javajj.lushTechTest.model.db.RocketDao
import com.javajj.lushTechTest.model.rocket.RocketResponse
import com.javajj.lushTechTest.model.network.RocketApi
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*


class RocketRepoTest {

    lateinit var rocketRepo:RocketRepo

    lateinit var rocketDao: RocketDao
    lateinit var rocketApi: RocketApi

    @Before
    fun setup(){
        rocketDao = mock(RocketDao::class.java)
        rocketApi = mock(RocketApi::class.java)

        rocketRepo = RocketRepo(rocketDao, rocketApi)
    }

    @Test
    fun isStoringRocketData(){
        val rocketResponse = RocketResponse(1, emptyList())
        doNothing().`when`(rocketDao).insertRockets(rocketResponse)

        rocketRepo.storeRocketData(rocketResponse)

        verify(rocketDao).insertRockets(rocketResponse)
    }
}