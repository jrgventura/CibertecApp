package com.cibertec.cibertecapp.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterViewModel: ViewModel() {

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    val userRegisterStatus = MutableLiveData<Boolean>()

    fun register(name: String, lastname: String,
                 email: String, password: String) {
        registerFirebase(name, lastname, email, password)
    }

    private fun registerFirebase(name: String, lastname: String,
                                 email: String, password: String) {

        auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val uid = it.result.user?.uid
                    uid?.let {
                        registerFirestore(uid, name, lastname, email)
                    }
                } else {
                    userRegisterStatus.value = false
                }
            }
    }

    private fun registerFirestore(uid: String, name: String,
                                  lastname: String, email: String) {
        firestore = FirebaseFirestore.getInstance()
        val userMap = hashMapOf(
            "nombre" to name,
            "apellidos" to lastname,
            "correo" to email
        )
        firestore.collection("usuarios").document(uid)
            .set(userMap)
            .addOnSuccessListener {
                userRegisterStatus.value = true
            }
            .addOnFailureListener {
                userRegisterStatus.value = false
            }
    }

}