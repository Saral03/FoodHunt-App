package com.example.foodhunt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

lateinit var img_logo:ImageView
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        img_logo=findViewById(R.id.img_logo)
        img_logo.alpha=0f
        img_logo.animate().setDuration(1500).alpha(1f).withEndAction(){
            val intent=Intent(this@SplashScreen,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }

    }
}