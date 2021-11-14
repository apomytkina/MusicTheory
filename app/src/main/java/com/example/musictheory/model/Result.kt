package com.example.musictheory.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "results",
    foreignKeys = [
        ForeignKey(
            entity = Test::class,
            parentColumns = ["id"],
            childColumns = ["id_test"],
            onDelete = CASCADE
        )
    ]
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
)
