package com.addenisov00.turkeyregions.data.network

import retrofit2.http.GET


interface CodesApiClient {
    @GET("data/regions.json")
    suspend fun getRegions(): List<CodeNetworkItem>

    @GET("data/translations/ru.json")
    suspend fun getRuRegions(): List<CodeNetworkItem>


}