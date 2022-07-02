package com.example.foodhunt

import android.content.Intent
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
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inp_email="saralhanda13@gmail.com"
        val inp_pass="Spicemi5"
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
                val intent=Intent(this@MainActivity,Login_Show::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}