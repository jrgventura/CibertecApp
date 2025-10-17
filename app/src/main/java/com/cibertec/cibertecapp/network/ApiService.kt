package com.cibertec.cibertecapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    private val URL_BASE = "https://reqres.in/"

    val apiService = Retrofit.Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CibertecApi::class.java)

}