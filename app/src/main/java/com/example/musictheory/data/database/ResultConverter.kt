package com.example.musictheory.data.database

import androidx.room.TypeConverter
import com.example.musictheory.model.Mistake
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ResultConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromList(list: List<String>): String {
        return list.joinToString(",")
    }

    @TypeConverter
    fun toList(str: String): List<String> {
        return str.split(",")
    }

    @TypeConverter
    fun toMistakeFromList(list: List<Mistake>): String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromMistakesToList(str: String): List<String> {
        val listType = object : TypeToken<List<Mistake>>() {}.type
        return  gson.fromJson(str, listType)
    }
}