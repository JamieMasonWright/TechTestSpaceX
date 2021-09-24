package com.javajj.lushTechTest.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.javajj.lushTechTest.model.db.DatabaseConstants.EXPORT_SCHEMA
import com.javajj.lushTechTest.model.db.DatabaseConstants.ROCKET_DATABASE_VERSION
import com.javajj.lushTechTest.model.rocket.RocketResponse

@Database(entities = [RocketResponse::class], version = ROCKET_DATABASE_VERSION, exportSchema = EXPORT_SCHEMA)
@TypeConverters(Converters::class)
abstract class RocketDatabase : RoomDatabase() {
    abstract val rocketDao: RocketDao
}