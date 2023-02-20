package com.example.turkeyregions.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@androidx.room.Dao
interface Dao {

    @Insert (onConflict = REPLACE)
    fun insertRegion(region: CodeEntity)

    @Query ("SELECT regionName FROM CodeEntity WHERE regionNumber is :regionNumber")
    suspend fun getRegionName(regionNumber: String): String
}