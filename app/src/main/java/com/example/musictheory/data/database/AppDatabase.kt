package com.example.musictheory.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.musictheory.model.Result

@Database(
    entities = [Result::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun resultsDao(): ResultsDao
}