package com.s.k_api.db

import androidx.room.*
import com.s.k_api.ConverterType
import com.s.k_api.model.RocketDetails
import com.s.k_api.model.SpaceRocket

// Database operations (Insert/ delete / Get)
@Dao
@TypeConverters(ConverterType::class)
interface RocketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRocketListfromAPI( rocketlist: List<SpaceRocket>)

    @Query("SELECT * FROM rockets_table")
    suspend fun getRocketList() :List<SpaceRocket>

    @Query("DELETE from rockets_table")
    suspend fun deleteDBRecords() : Int


    // details screen

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDetailsListfromAPI(details_list: RocketDetails)

    @Query("SELECT * FROM rocket_details_table")
    suspend fun getRocketDetails() : RocketDetails




}