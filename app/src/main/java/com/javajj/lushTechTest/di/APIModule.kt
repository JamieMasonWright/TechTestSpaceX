package com.javajj.lushTechTest.di

import com.javajj.lushTechTest.model.network.RocketApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun provideUserApi(retrofit: Retrofit) : RocketApi {
        return retrofit.create(RocketApi::class.java)
    }

    single { provideUserApi(get()) }
}