package com.javajj.lushTechTest.model.db

/**
 * This object is used to provide database-related constants to the application
 */
object DatabaseConstants {
    /**
     * Database Name
     */
    const val ROCKET_DB = "rockets.db"

    /**
     * Database Version
     */
    const val ROCKET_DATABASE_VERSION = 1

    /**
     * Export Schema Options
     */
    const val EXPORT_SCHEMA = false

    /**
     * Query to retrieve rockets from the RocketRepo
     */
    const val SELECT_ALL_ROCKETS_QUERY = "SELECT * FROM RocketResponse"

    /**
    Query to remove rockets from the RocketRepo
     */
    const val DELETE_ALL_ROCKETS_QUERY = "DELETE FROM RocketResponse"


}