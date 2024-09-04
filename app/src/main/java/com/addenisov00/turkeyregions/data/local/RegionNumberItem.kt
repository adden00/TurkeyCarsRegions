package com.addenisov00.turkeyregions.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RegionNumberItem(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "regionNumber")
    val regionNumber: String,

    @ColumnInfo(name = "regionName")
    val regionName: String
)