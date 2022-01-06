package com.example.arty3.roomdatabase

import androidx.room.Database
import com.example.arty3.model.Art

@Database(entities = [Art::class],version = 1)
abstract class ArtDb {
    abstract fun artDao(): artDao
}