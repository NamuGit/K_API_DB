package com.s.k_api

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.s.k_api.model.Height
import java.io.ByteArrayOutputStream

@ProvidedTypeConverter
class ConverterType {

    var gson = Gson()

    @TypeConverter
    fun fromAnyToString(value: Any?): String? {
        return if (value == null) null else value.toString()
    }




    @TypeConverter
    fun foodItemToString(height: List<Height>): String {
        return gson.toJson(height)
    }

    @TypeConverter
    fun stringToFoodItem(data: String): List<Height> {
        val listType = object : TypeToken<List<Height>>() {
        }.type
        return gson.fromJson(data, listType)
    }


//    @Converter
//    fun toBitmap(bytes: ByteArray): Bitmap {
//        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
//    }
//
//    @Converter
//    fun fromBitmap(bmp: Bitmap): ByteArray {
//        val outputStream = ByteArrayOutputStream()
//        bmp.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
//        return outputStream.toByteArray()
//    }

}