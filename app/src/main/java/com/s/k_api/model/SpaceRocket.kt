package com.s.k_api.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// works as model(variables) for view and entity for db as well

@Entity(tableName = "rockets_table")
data class SpaceRocket(
    @PrimaryKey(autoGenerate = true)
    val Rid:Int,
    val id: String,
    val active: Boolean,
    val company: String,
    val cost_per_launch: Int,
    val country: String,
    val description: String,
//    val diameter: Diameter,
//    val engines: Engines,
//    val flickr_images: List<String>,
//    val height: Height,
    val name: String,
    val success_rate_pct: Int,
    val wikipedia: String
)