package com.example.turkeyregions.app.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turkeyregions.data.local.Dao
import com.example.turkeyregions.data.local.RegionNumberItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegionViewModel @Inject constructor(private val dao: Dao): ViewModel() {

    val currentRegion = MutableLiveData<String>()
    val currentNumbers = MutableLiveData<List<RegionNumberItem>>(listOf())
    private val allNumbers = MutableLiveData<List<RegionNumberItem>>()

    init {
        currentRegion.value = "Введите код региона"
        getAllRegions()


    }


    fun searchCode(regionNumber: String) {
        viewModelScope.launch {
            val result = dao.getRegionName(regionNumber)
            currentRegion.postValue(result)
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
            allNumbers.postValue(dao.getAllNumbers())
        }
    }
}