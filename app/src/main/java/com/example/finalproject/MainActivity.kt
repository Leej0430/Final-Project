package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signIn:Button = findViewById(R.id.btn_sign_in)
        val signUp:Button = findViewById(R.id.btn_sign_up)

    signIn.setOnClickListener {
        val intent = Intent(this,SignIn::class.java)
        startActivity(intent)
    }
    }
}