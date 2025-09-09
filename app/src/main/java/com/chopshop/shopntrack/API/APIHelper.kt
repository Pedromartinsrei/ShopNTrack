package com.chopshop.shopntrack.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIHelper {

    val baseUrl = "http://192.168.1.107:8080/" //localtestserver.ddns.net

    fun getInstance(): Retrofit{
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}