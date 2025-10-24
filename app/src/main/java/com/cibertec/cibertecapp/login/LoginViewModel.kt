package com.cibertec.cibertecapp.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cibertec.cibertecapp.network.response.LoginResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import java.util.regex.Pattern


class LoginViewModel: ViewModel() {

    private lateinit var auth: FirebaseAuth

    private val repository = LoginRepository()

    val userLoginSuccess = MutableLiveData<Boolean>()

    val userLoginError = MutableLiveData<Boolean>()
    private val _client = MutableLiveData<LoginResponse?>()
    val client: LiveData<LoginResponse?> get() = _client

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun loginRetrofit(email: String, pass: String) {
        if (email.isEmpty() || pass.isEmpty()) {
            userLoginError.value = true
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            userLoginError.value = true
        } else if (pass.length < 5) {
            userLoginError.value = true
        } else {
            // login(email, pass)
            loginFirebase(email, pass)
        }
    }

    private fun login(email: String, pass: String) {
        viewModelScope.launch {
            try {
                val result = repository.login(email, pass)
                if (result.isSuccess) {
                    _client.postValue(result.getOrNull())
                    _error.postValue(null)
                } else {
                    _client.postValue(null)
                    _error.postValue(result.exceptionOrNull()?.message)
                }
            } catch (e: Exception) {
                _client.postValue(null)
                _error.postValue(e.message)
            }
        }
    }

    private fun loginFirebase(email: String, pass: String) {
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener {
                userLoginSuccess.value = it.isSuccessful
            }
    }


}