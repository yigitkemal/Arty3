package com.example.arty3.repo

import androidx.lifecycle.LiveData
import com.example.arty3.model.Art
import com.example.arty3.model.ImageResponse
import com.example.arty3.util.Resource

interface ArtRepositoryInterface {

    suspend fun insertArt(art: Art)

    suspend fun deleteArt(art: Art)

    fun getArt(): LiveData<List<Art>>

    suspend fun searchImage(imageString: String): Resource<ImageResponse>

}