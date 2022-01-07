package com.example.arty3.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.arty3.model.Art

@Database(entities = [Art::class],version = 1)
abstract class ArtDb: RoomDatabase() {
    abstract fun artDao(): artDao
}