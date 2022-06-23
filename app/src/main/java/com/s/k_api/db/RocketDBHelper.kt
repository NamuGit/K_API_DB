package com.s.k_api.db

import android.content.Context
import androidx.room.*

import com.s.k_api.ConverterType
import com.s.k_api.model.RocketDetails
import com.s.k_api.model.SpaceRocket

@Database(entities = [SpaceRocket::class,RocketDetails::class], version = 1)
@TypeConverters(ConverterType::class)
abstract class RocketDBHelper: RoomDatabase() {

    // returns Doa
    abstract fun getDao() : RocketDao


    // get the Instance of db : this is a singleton class to avoid creation of multiple objects
    companion object{
        private var INSTANCE : RocketDBHelper?= null

        fun getDBInstance(context: Context) : RocketDBHelper{

            if (INSTANCE == null){
                synchronized(this ){
                    INSTANCE = Room.databaseBuilder(context, RocketDBHelper::class.java,"Space_RocketsDB").build()
                }
            }
            return INSTANCE!!
        }
    }




}