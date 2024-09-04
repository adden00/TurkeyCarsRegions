package com.addenisov00.turkeyregions.data.network

import android.util.Log
import javax.inject.Inject

class NetworkService @Inject constructor(private val api: CodesApiClient) {
    suspend fun getAllRegions(): List<CodeNetworkItem> {
        var result = listOf<CodeNetworkItem>()
        try {
            result = api.getRegions()
        } catch (e: java.lang.Exception) {
            Log.d("MyLog", e.toString())
        }
        return result
    }

    suspend fun getAllRuRegions(): List<CodeNetworkItem> {
        var result = listOf<CodeNetworkItem>()
        try {
            result = api.getRuRegions()
        } catch (e: java.lang.Exception) {
            Log.d("MyLog", e.toString())
        }
        return result
    }
}