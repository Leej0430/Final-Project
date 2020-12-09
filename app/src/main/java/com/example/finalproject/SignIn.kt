package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val btn: Button = findViewById(R.id.button)

        btn.setOnClickListener {
            val intent = Intent(this,Location::class.java)
            startActivity(intent)
        }
    }
}