package com.example.jigishakitchenapp.api

import com.example.jigishakitchenapp.model.CategoriesItem
import com.example.jigishakitchenapp.model.HomeApiResponse
import com.example.jigishakitchenapp.model.HomeItem
import com.example.jigishakitchenapp.model.MenuItem
import org.w3c.dom.ls.LSInput
import retrofit2.Response
import retrofit2.http.GET

interface JigishaKitchenAPI {

    @GET("home")
    suspend fun getHomeData(): Response<HomeApiResponse>

    @GET("getallcategories")
    suspend fun getAllCategories(): Response<List<CategoriesItem>>

    @GET("getmenu")
    suspend fun getMenu(categories_id: String) : Response<List<MenuItem>>
}