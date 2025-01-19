package com.example.jigishakitchenapp.repository

import com.example.jigishakitchenapp.api.JigishaKitchenAPI
import com.example.jigishakitchenapp.model.HomeItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class HomeRepository @Inject constructor(private val jigishaKitchenAPI: JigishaKitchenAPI) {

    private val _homeData = MutableStateFlow<List<HomeItem>>(emptyList())
    val homeData: StateFlow<List<HomeItem>>
        get() = _homeData

    suspend fun getHomeData() {
        val response = jigishaKitchenAPI.getHomeData()
        if (response.isSuccessful && response.body() != null) {
            response.body()?.data?.let { _homeData.emit(it) }
        }
    }
}