package com.cibertec.cibertecapp.login

import com.cibertec.cibertecapp.network.ApiService
import com.cibertec.cibertecapp.network.request.LoginRequest
import com.cibertec.cibertecapp.network.response.LoginResponse

class LoginRepository {

    private val apiService = ApiService().apiService

    suspend fun login(email: String, pass: String): Result<LoginResponse> {
        return try {
            val response = apiService.login(LoginRequest(email, pass))
            Result.success(response)
        } catch (e: retrofit2.HttpException) {
            if(e.code() == 500) {
                val errorCode = e.code()
                val errorMessage = e.message()
                Result.failure(Exception("Error: $errorCode - $errorMessage"))
            } else if(e.code() == 401) {
                val errorCode = e.code()
                val errorMessage = e.message()
                Result.failure(Exception("Error: $errorCode - $errorMessage"))
            }else {
                Result.failure(e)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}