package com.chopshop.shopntrack.API

import com.chopshop.shopntrack.shop.Shop
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("/hello")
    suspend fun getHello() : Response<Shop>
}