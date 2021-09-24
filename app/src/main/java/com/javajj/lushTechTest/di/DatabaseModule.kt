package com.javajj.lushTechTest.di

import android.app.Application
import androidx.room.Room
import com.javajj.lushTechTest.model.db.DatabaseConstants.ROCKET_DB
import com.javajj.lushTechTest.model.db.RocketDao
import com.javajj.lushTechTest.model.db.RocketDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application) : RocketDatabase {
        return Room.databaseBuilder(application, RocketDatabase::class.java, ROCKET_DB)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: RocketDatabase) : RocketDao {
        return database.rocketDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}