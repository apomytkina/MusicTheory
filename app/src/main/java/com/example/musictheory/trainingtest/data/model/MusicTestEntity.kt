package com.example.musictheory.trainingtest.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tests")
data class MusicTestEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "sections_id")
    val sectionsId: String,
    @ColumnInfo(name = "question_array")
    val questionArray: List<String>,
    @ColumnInfo(name = "answer_array")
    val answerArray: List<List<String>>,
    @ColumnInfo(name = "displayed_elements")
    val displayedElements: List<String>
)
