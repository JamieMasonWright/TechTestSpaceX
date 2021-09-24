package com.javajj.lushTechTest.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.javajj.lushTechTest.model.db.DatabaseConstants.DELETE_ALL_ROCKETS_QUERY
import com.javajj.lushTechTest.model.db.DatabaseConstants.SELECT_ALL_ROCKETS_QUERY
import com.javajj.lushTechTest.model.rocket.RocketResponse

/**
 * Used to perform data access operations on the RocketDatabase
 */
@Dao
interface RocketDao {

    /**
     * Insert rocket into RocketRepo table
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRockets(rocketResponse: RocketResponse)

    /**
     * Get rocket data from the RocketRepo table
     */
    @Query(SELECT_ALL_ROCKETS_QUERY)
    fun getAllRockets() : LiveData<RocketResponse>

    /**
     * Delete rocket data from the RocketRepo table
     */
    @Query(DELETE_ALL_ROCKETS_QUERY)
    fun deleteAllRockets()
}