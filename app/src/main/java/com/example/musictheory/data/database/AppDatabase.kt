package com.example.musictheory.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.musictheory.model.Result
import com.example.musictheory.model.Test

@Database(
    entities = [Result::class, Test::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ResultConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun resultsDao(): ResultsDao
}