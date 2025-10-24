package com.cibertec.cibertecapp.register

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cibertec.cibertecapp.R
import kotlin.random.Random

class RegisterActivity: AppCompatActivity() {

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        val edtName = findViewById<EditText>(R.id.edtName)
        val edtLastname = findViewById<EditText>(R.id.edtLastname)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val name = edtName.text.toString()
            val lastname = edtLastname.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            registerViewModel.register(name, lastname, email, password)
        }

        registerViewModel.userRegisterStatus.observe(this) { result ->
            if (result) {
                Toast.makeText(this, "Registro correcto", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Error: verifique datos", Toast.LENGTH_SHORT).show()
            }
        }

    }

}