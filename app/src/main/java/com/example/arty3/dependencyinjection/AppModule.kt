package com.example.arty3.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.example.arty3.api.RetrofitAPI
import com.example.arty3.roomdatabase.ArtDb
import com.example.arty3.util.Util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule  {

    @Singleton
    @Provides
    fun injectRoomDatabase(@ApplicationContext context: Context)= Room.databaseBuilder(
        context, ArtDb::class.java,"ArtyDb"
    ).build()

    @Singleton
    @Provides
    fun injectDao(database: ArtDb) = database.artDao()

    @Singleton
    @Provides
    fun injectRetrofitAPI(): RetrofitAPI{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(RetrofitAPI::class.java)
    }

}