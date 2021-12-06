package com.example.musictheory.data

import com.example.musictheory.data.database.ResultsDao
import com.example.musictheory.model.Result
import com.example.musictheory.model.Test
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class LocalDataSource @Inject constructor(
    private val resultsDao: ResultsDao
) {

    /**
     * Возвращамем id для передачи на ResultFragment
     */
    suspend fun saveResult(result: Result) =
        withContext(Dispatchers.IO) {
            resultsDao.saveResult(result)
        }

    suspend fun saveTest(test: Test) {
        withContext(Dispatchers.IO) {
            resultsDao.saveTest(test)
        }
    }

    fun getResultById(id: Long): Flow<List<Result>> {
        return resultsDao.getResult(id)
    }

    fun getTestById(id: String): Flow<List<Test>> {
        return resultsDao.getTest(id)
    }
}
