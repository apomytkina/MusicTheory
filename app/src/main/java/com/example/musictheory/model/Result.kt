package com.example.musictheory.model

import androidx.room.Entity


@Entity(tableName = "results")
data class Result(
    val id: Int,
    val idTest: Int,
    val mistakeCount: Int,
    val mistakeArray: Array<Array<Int>>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Result

        if (id != other.id) return false
        if (idTest != other.idTest) return false
        if (mistakeCount != other.mistakeCount) return false
        if (!mistakeArray.contentDeepEquals(other.mistakeArray)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + idTest
        result = 31 * result + mistakeCount
        result = 31 * result + mistakeArray.contentDeepHashCode()
        return result
    }
}