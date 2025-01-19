package com.example.jigishakitchenapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jigishakitchenapp.model.HomeItem
import com.example.jigishakitchenapp.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject public constructor(
   private val homeRepository: HomeRepository
) : ViewModel() {

    val homeData : StateFlow<List<HomeItem>>
        get() = homeRepository.homeData

    init {
        viewModelScope.launch {
            homeRepository.getHomeData()
        }
    }
}