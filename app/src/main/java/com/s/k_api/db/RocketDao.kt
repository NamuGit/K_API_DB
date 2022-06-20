package com.s.k_api.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.s.k_api.model.SpaceRocket

// Database operations (Insert/ delete / Get)
@Dao
interface RocketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRocketListfromAPI( rocketlist: List<SpaceRocket>)

    @Query("SELECT * FROM rockets_table")
    suspend fun getRocketList() : List<SpaceRocket>

    @Query("DELETE from rockets_table")
    suspend fun deleteDBRecords() : Int

}