package com.addenisov00.turkeyregions.data.mappers

import com.addenisov00.turkeyregions.data.local.RegionNumberItem
import com.addenisov00.turkeyregions.data.network.CodeNetworkItem

fun CodeNetworkItem.toDao(): RegionNumberItem {
    return RegionNumberItem(this.code, this.name)
}