package com.example.foodhunt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val intent=Intent(this@SplashScreen,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}