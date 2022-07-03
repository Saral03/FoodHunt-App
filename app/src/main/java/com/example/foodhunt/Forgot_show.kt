package com.example.foodhunt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

lateinit var mobile_fp_tv:TextView
lateinit var email_fp_tv:TextView
class Forgot_show : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_show)
        mobile_fp_tv=findViewById(R.id.mobile_fp_tv)
        email_fp_tv=findViewById(R.id.email_fp_tv)
        mobile_fp_tv.setText(intent.getStringExtra("mobile_fp"))
        email_fp_tv.setText(intent.getStringExtra("email_fp"))
    }
}