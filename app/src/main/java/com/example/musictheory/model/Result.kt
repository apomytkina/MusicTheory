package com.example.musictheory.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey


@Entity(
    tableName = "results",
    foreignKeys = [ForeignKey(
        entity = Test::class,
        parentColumns = ["id"],
        childColumns = ["id_test"],
        onDelete = CASCADE
    )]
)
data class Result(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "id_test")
    val idTest: Int,
    @ColumnInfo(name = "mistake_count")
    val mistakeCount: Int,
    @ColumnInfo(name = "mistake_array")
    val mistakeArray: List<Mistake>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Result

        if (id != other.id) return false
        if (idTest != other.idTest) return false
        if (mistakeCount != other.mistakeCount) return false
//        if (!mistakeArray.contentDeepEquals(other.mistakeArray)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + idTest
        result = 31 * result + mistakeCount
//        result = 31 * result + mistakeArray.contentDeepHashCode()
        return result
    }
}