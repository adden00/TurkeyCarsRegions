package com.example.turkeyregions.app.di

import android.content.Context
import com.example.turkeyregions.data.local.RegionDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = RegionDataBase.getInstance(context)

    @Provides
    @Singleton
    fun provideDao(database: RegionDataBase) = database.getDao()
}