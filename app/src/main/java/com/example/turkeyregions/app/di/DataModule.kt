package com.example.turkeyregions.app.di

import android.content.Context
import com.example.turkeyregions.app.Constants
import com.example.turkeyregions.data.local.RegionDataBase
import com.example.turkeyregions.data.network.CodesApiClient
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
class DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = RegionDataBase.getInstance(context)

    @Provides
    @Singleton
    fun provideDao(database: RegionDataBase) = database.getDao()

    @Provides
    @Singleton
    fun provideApiClient() = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(CodesApiClient::class.java)


}