package com.example.musictheory.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.musictheory.model.Result
import com.example.musictheory.model.Test
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultsDao {

    @Insert
    fun saveResult(result: Result)

    @Insert
    fun saveTest(test: Test)

    @Query("SELECT * FROM results WHERE id = :id")
    fun getResult(id: Int): Flow<List<Result>>

    @Query("SELECT * FROM tests WHERE id = :id")
    fun getTest(id: Int): Flow<List<Test>>
}
