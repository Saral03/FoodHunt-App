package com.example.foodhunt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

lateinit var name_reg_tv:TextView
lateinit var email_reg_tv:TextView
lateinit var mobile_reg_tv:TextView
lateinit var delivery_reg_tv:TextView
lateinit var pass_reg_tv:TextView
lateinit var pass_confirm_reg_tv:TextView
class Registration_Show : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_show)
        name_reg_tv=findViewById(R.id.name_reg_tv)
        email_reg_tv=findViewById(R.id.email_reg_tv)
        mobile_reg_tv=findViewById(R.id.mobile_reg_tv)
        delivery_reg_tv=findViewById(R.id.delivery_reg_tv)
        pass_reg_tv=findViewById(R.id.pass_reg_tv)
        pass_confirm_reg_tv=findViewById(R.id.pass_confirm_reg_tv)
        name_reg_tv.setText(intent.getStringExtra("Name"))
        email_reg_tv.setText(intent.getStringExtra("Email_reg"))
        mobile_reg_tv.setText(intent.getStringExtra("Mobile_reg"))
        delivery_reg_tv.setText(intent.getStringExtra("delivery_reg"))
        pass_reg_tv.setText(intent.getStringExtra("pass_reg"))
        pass_confirm_reg_tv.setText((intent.getStringExtra("pass_confirm_reg")))
    }

    override fun onPause() {
        super.onPause()
        val intent= Intent(this@Registration_Show,MainActivity::class.java)
        startActivity(intent)
    }
}