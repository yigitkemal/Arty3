package com.example.arty3.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "arts")
data class Art (
    var name: String,
    var artistName: String,
    var year: String,
    var imageUrl: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
        )