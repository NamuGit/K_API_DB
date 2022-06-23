package com.s.k_api.model

import androidx.databinding.adapters.Converters
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.s.k_api.ConverterType

@Entity(tableName = "rocket_details_table")
@TypeConverters(ConverterType::class)
data class RocketDetails(
    @PrimaryKey
    var id:String,
    val active: Boolean,
    val cost_per_launch: Int,
    val description: String,
//    val diameter: Diameter,
//    val flickr_images: List<String>,
//    @TypeConverters(Converters::class)
//    val height: Height,
    val name: String,
    val success_rate_pct: Int,
    val wikipedia: String
)