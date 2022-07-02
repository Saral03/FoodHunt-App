package com.example.foodhunt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

lateinit var mobile_fp:EditText
lateinit var email_fp:EditText
lateinit var but_fp:Button

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        mobile_fp=findViewById(R.id.mobile_fp)
        email_fp=findViewById(R.id.email_fp)
        but_fp=findViewById(R.id.but_fp)
    }
}