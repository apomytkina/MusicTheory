package com.example.musictheory.data

import com.example.musictheory.data.database.ResultsDao
import com.example.musictheory.model.Result
import com.example.musictheory.model.Test
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val resultsDao: ResultsDao
) {

    suspend fun saveResult(result: Result) {
        withContext(Dispatchers.IO) {
            resultsDao.saveResult(result)
        }
    }

    suspend fun saveTest(test: Test) {
        withContext(Dispatchers.IO) {
            resultsDao.saveTest(test)
        }
    }

    fun getResultById(id: Int): Flow<List<Result>> {
        return resultsDao.getResult(id)
    }

    fun getTestById(id: Int): Flow<List<Test>> {
        return resultsDao.getTest(id)
    }
}