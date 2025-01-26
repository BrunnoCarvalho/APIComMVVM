package com.brunocarvalho.apicommvvm.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    val URL = "https://jsonplaceholder.typicode.com/"

    fun getJsonPlace(): JsonPlaceAPI{

        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JsonPlaceAPI::class.java)
    }

}