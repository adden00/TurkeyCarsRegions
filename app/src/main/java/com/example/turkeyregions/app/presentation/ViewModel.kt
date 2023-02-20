package com.example.turkeyregions.app.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turkeyregions.data.local.Dao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegionViewModel @Inject constructor(private val dao: Dao): ViewModel() {

    val currentRegion = MutableLiveData<String>()

    init {
        currentRegion.value = "Введите код региона"
    }


    fun searchCode(regionNumber: String) {
        viewModelScope.launch {
            val result = dao.getRegionName(regionNumber)
            currentRegion.postValue(result)




        }
    }
}