package com.example.foodhunt

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.foodhunt.R

lateinit var email_tv:TextView
lateinit var pass_tv:TextView
lateinit var sp: SharedPreferences
class Login_Show : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sp=getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE)
        setContentView(R.layout.activity_login_show)
        email_tv=findViewById(R.id.email_tv)
        pass_tv=findViewById(R.id.pass_tv)
        email_tv.setText((sp.getString("Email","HI")))
        pass_tv.setText((sp.getString("Password","HI")))

    }
}