package com.example.foodhunt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

lateinit var mobile_fp:EditText
lateinit var email_fp:EditText
lateinit var but_fp:Button

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        var isAllFieldsChecked = false
        mobile_fp=findViewById(R.id.mobile_fp)
        email_fp=findViewById(R.id.email_fp)
        but_fp=findViewById(R.id.but_fp)
        but_fp.setOnClickListener {
            isAllFieldsChecked = CheckAllFields()
            if (isAllFieldsChecked) {
                val intent = Intent(this@ForgotPassword, Forgot_show::class.java)
                intent.putExtra("mobile_fp", mobile_fp.text.toString())
                intent.putExtra("email_fp", email_fp.text.toString())
                startActivity(intent)
            }
        }
    }
    fun CheckAllFields():Boolean{
        if(mobile_fp.length()==0){
            mobile_fp.setError("this field is required")
            return false
        }
        if (mobile_fp.length()<10){
            mobile_fp.setError("invalid")
            return false
        }
        if (email_fp.length()==0){
            email_fp.setError("this field is required")
            return false
        }
        if (email_fp.length()<15){
            email_fp.setError("minimum 15 characters")
            return false
        }
        return true
    }
}