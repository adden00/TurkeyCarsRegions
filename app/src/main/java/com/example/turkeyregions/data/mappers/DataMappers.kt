package com.example.turkeyregions.data.mappers

import com.example.turkeyregions.data.local.RegionNumberItem
import com.example.turkeyregions.data.network.CodeNetworkItem

fun CodeNetworkItem.toDao(): RegionNumberItem {
    return RegionNumberItem(this.code, this.name)
}