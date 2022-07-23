package com.example.foodhunt

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

lateinit var email:EditText
lateinit var pass:EditText
lateinit var fp:TextView
lateinit var but:Button
lateinit var register:TextView

lateinit var sharedPreferences: SharedPreferences
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inp_email="Sa"
        val inp_pass="Spicemi5"
        sharedPreferences=getSharedPreferences(getString(R.string.my_preference),Context.MODE_PRIVATE)
        val IsloggedIn= sharedPreferences.getBoolean("IsloggedIn",false)
        setContentView(R.layout.activity_main)
        if (IsloggedIn){
            val intent=Intent(this@MainActivity,Navigation::class.java)
            startActivity(intent)
            finish()
        }
        email=findViewById(R.id.email)
        pass=findViewById(R.id.pass)
        fp=findViewById(R.id.fp)
        but=findViewById(R.id.but)
        register=findViewById(R.id.register)

        
        but.setOnClickListener { 
            val check_email=email.text.toString()
            val check_pass=pass.text.toString()
            if (check_email==inp_email && check_pass==inp_pass){
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                val intent=Intent(this@MainActivity,Navigation::class.java)
                savelogin()
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }
        register.setOnClickListener {
            val intent=Intent(this@MainActivity,Registration::class.java)
            startActivity(intent)

        }
        fp.setOnClickListener {
            val intent=Intent(this@MainActivity,ForgotPassword::class.java)
            startActivity(intent)
        }
    }
    fun savelogin(){
        sharedPreferences.edit().putBoolean("IsloggedIn",true).apply()
    }

//    override fun onPause() {
//        super.onPause()
//        finish()
//    }


}