package com.javajj.lushTechTest.model.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.javajj.lushTechTest.model.rocket.Rocket

/**
 * Class is used by Room database to convert unknown data types
 * to JSON (String format) and then back to their original data types
 * when retrieved from the database.
 */
class Converters{

    /**
     * Function converts list of rocket objects to String
     */
    @TypeConverter
    fun rocketListToJson(rocket: List<Rocket>) : String{
        return Gson().toJson(rocket)
    }

    /**
     * Function takes a parameter of string and retrieves a list
     */
    @TypeConverter
    fun rocketListFromJson(value: String): List<Rocket> {
        return Gson().fromJson(value, Array<Rocket>::class.java).toList()
    }
}