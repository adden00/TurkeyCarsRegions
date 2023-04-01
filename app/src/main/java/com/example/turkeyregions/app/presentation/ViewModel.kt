package com.example.turkeyregions.app.presentation

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.turkeyregions.data.local.Dao
import com.example.turkeyregions.data.local.RegionNumberItem
import com.example.turkeyregions.data.network.CodeNetworkItem
import com.example.turkeyregions.data.network.NetworkService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegionViewModel @Inject constructor(
    private val dao: Dao,
    private val networkService: NetworkService
) : ViewModel() {

    val currentRegion = MutableLiveData<String>()
    val currentNumbers = MutableLiveData<List<RegionNumberItem>>(listOf())
    val isLoading = MutableLiveData<Boolean>(false)
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

    fun updateRegions(context: Context) {
        isLoading.value = true
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
            isLoading.postValue(false)

            val message = if (trCodes.size == 0)
                "Ошибка при загрузке данных!"
            else
                "данные обновлены!"
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}

private fun CodeNetworkItem.toDao(): RegionNumberItem {
    return RegionNumberItem(this.code, this.name)
}
