package com.example.educationaccessplatform

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen { username, password, showError ->
                if (username == "169168" && password == "169168") {
                   startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    showError("Invalid username or password")
                }
            }
        }
    }
}
