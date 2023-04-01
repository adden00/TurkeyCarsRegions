package com.example.turkeyregions.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@androidx.room.Dao
interface Dao {

    @Insert(onConflict = REPLACE)
    fun insertRegion(region: RegionNumberItem)

    @Insert(onConflict = REPLACE)
    suspend fun insertDynamicRegion(region: RegionNumberItem)


    @Query("SELECT regionName FROM RegionNumberItem WHERE regionNumber is :regionNumber")
    suspend fun getRegionName(regionNumber: String): String

    @Query("SELECT regionNumber FROM RegionNumberItem WHERE regionName is :regionName ")
    suspend fun getRegionNumber(regionName: String): String

    @Query("SELECT * FROM RegionNumberItem")
    suspend fun getAllNumbers(): List<RegionNumberItem>

    @Query("DELETE FROM RegionNumberItem")
    suspend fun deleteAllNumbers()
}