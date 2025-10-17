package com.cibertec.cibertecapp.network

import com.cibertec.cibertecapp.network.request.LoginRequest
import com.cibertec.cibertecapp.network.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface CibertecApi {

    @POST("api/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

}