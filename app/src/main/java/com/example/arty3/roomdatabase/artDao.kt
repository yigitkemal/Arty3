package com.example.arty3.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.arty3.model.Art

@Dao
interface artDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArt(art: Art)

    @Delete
    suspend fun deleteArt(art:Art)

    @Query("SELECT * FROM arts")
    fun observeArts(): LiveData<List<Art>>

}