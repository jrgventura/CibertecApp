package com.cibertec.cibertecapp.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cibertec.cibertecapp.MainActivity
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.news.NewsActivity

class LoginActivity: AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class]

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val pass = edtPassword.text.toString()
            loginViewModel.loginRetrofit(email, pass)
        }

        loginViewModel.client.observe(this, Observer { usuario ->
            usuario?.let {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        })
        loginViewModel.error.observe(this, Observer { error ->
            error?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })

        btnRegister.setOnClickListener {

        }

    }

}