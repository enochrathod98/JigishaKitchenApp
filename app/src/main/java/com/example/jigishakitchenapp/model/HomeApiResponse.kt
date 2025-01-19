package com.example.jigishakitchenapp.model

data class HomeApiResponse(
    val status: String,
    val message: String,
    val data: List<HomeItem>
)
