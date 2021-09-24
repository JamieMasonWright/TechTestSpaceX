package com.javajj.lushTechTest.di

import com.javajj.lushTechTest.model.db.RocketDao
import com.javajj.lushTechTest.model.network.RocketApi
import com.javajj.lushTechTest.repository.RocketRepo
import org.koin.dsl.module

val repoModule = module {
    fun provideRepository(dao: RocketDao, api: RocketApi) : RocketRepo {
        return RocketRepo(dao, api)
    }

    single { provideRepository(get(), get()) }
}