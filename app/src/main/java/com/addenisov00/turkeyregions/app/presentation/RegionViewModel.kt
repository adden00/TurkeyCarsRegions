package com.addenisov00.turkeyregions.app.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.addenisov00.turkeyregions.R
import com.addenisov00.turkeyregions.data.local.Dao
import com.addenisov00.turkeyregions.data.local.RegionNumberItem
import com.addenisov00.turkeyregions.data.local.StringProvider
import com.addenisov00.turkeyregions.data.mappers.toDao
import com.addenisov00.turkeyregions.data.network.NetworkService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegionViewModel @Inject constructor(
    private val dao: Dao,
    private val networkService: NetworkService,
    private val stringProvider: StringProvider
) : ViewModel() {

    val currentRegion = MutableLiveData<String>() //string res
    val currentNumbers = MutableLiveData<List<RegionNumberItem>>(listOf())
    private val allNumbers = MutableLiveData<List<RegionNumberItem>>()

    init {
        currentRegion.value = stringProvider.provideString(R.string.type_code)
        updateRegions()
        getAllRegions()

    }


    fun searchCode(regionNumber: String) {
        if (regionNumber.length < 2)
            currentRegion.value = stringProvider.provideString(R.string.type_code)
        else {
            viewModelScope.launch {
                val result = dao.getRegionName(regionNumber)
                currentRegion.postValue(result ?: stringProvider.provideString(R.string.wrong_region))
            }
        }
    }

    fun searchRegion(query: String) {
        val result = allNumbers.value?.filter {
            query.lowercase() in it.regionName.lowercase()
        }
        currentNumbers.value = result ?: listOf()
    }

    private fun getAllRegions() {
        viewModelScope.launch {
            val result = dao.getAllNumbers()
            allNumbers.postValue(result)
            currentNumbers.postValue(result)
        }
    }

    private fun updateRegions() {
        viewModelScope.launch {
            val trCodes = networkService.getAllRegions().toMutableList()
            val ruCodes = networkService.getAllRuRegions()


            if (trCodes.size != 0) {
                for (i in trCodes.indices) {
                    trCodes[i] = trCodes[i].copy(name = "${trCodes[i].name} (${ruCodes[i].name})")
                }
                dao.deleteAllNumbers()
                trCodes.forEach {
                    dao.insertDynamicRegion(it.toDao())
                }
                getAllRegions()
            }
        }
    }
}


