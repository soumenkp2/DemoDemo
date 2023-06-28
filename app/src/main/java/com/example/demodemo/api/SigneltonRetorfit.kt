package com.example.demodemo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SingeltonRetorfit {
    private const val BASE_URL = "https://api.quotable.io/"

    fun getInstance() : Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}