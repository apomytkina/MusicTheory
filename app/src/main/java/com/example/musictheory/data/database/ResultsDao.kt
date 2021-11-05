package com.example.musictheory.data.database

import androidx.room.Insert
import androidx.room.Query
import com.example.musictheory.model.Result
import kotlinx.coroutines.flow.Flow


interface ResultsDao {

    @Insert
    fun saveResult(result: Result)

    @Query("SELECT * FROM results WHERE id = :id")
    fun getResult(id: Int): Flow<List<Result>>
}