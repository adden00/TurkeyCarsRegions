package com.addenisov00.turkeyregions.app.di

import android.content.Context
import com.addenisov00.turkeyregions.app.Constants
import com.addenisov00.turkeyregions.data.local.RegionDataBase
import com.addenisov00.turkeyregions.data.local.StringProvider
import com.addenisov00.turkeyregions.data.local.StringProviderImpl
import com.addenisov00.turkeyregions.data.network.CodesApiClient
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
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = RegionDataBase.getInstance(context)

    @Provides
    @Singleton
    fun provideDao(database: RegionDataBase) = database.getDao()

    @Provides
    @Singleton
    fun provideApiClient(): CodesApiClient = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(CodesApiClient::class.java)

    @Provides
    fun provideStringProvider(@ApplicationContext context: Context): StringProvider =
        StringProviderImpl(context)
}