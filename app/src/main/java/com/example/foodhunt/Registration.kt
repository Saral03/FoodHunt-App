package com.example.foodhunt


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

lateinit var name_reg: EditText
lateinit var email_reg: EditText
lateinit var mobile_reg: EditText
lateinit var delivery_reg: EditText
lateinit var pass_reg: EditText
lateinit var pass_confirm_reg: EditText
lateinit var but_reg:Button
class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        title="Register"
        name_reg=findViewById(R.id.name_reg)
        email_reg=findViewById(R.id.email_reg)
        mobile_reg=findViewById(R.id.mobile_reg)
        delivery_reg=findViewById(R.id.delivery_reg)
        pass_reg=findViewById(R.id.pass_reg)
        pass_confirm_reg=findViewById(R.id.pass_confirm_reg)
        but_reg=findViewById(R.id.but_reg)
        var isAllFieldChecked=false
            but_reg.setOnClickListener {
                isAllFieldChecked=CheckAllFields()
                if (isAllFieldChecked) {
                    if (pass_reg.text.toString() == pass_confirm_reg.text.toString()) {
                        val intent = Intent(this@Registration, Registration_Show::class.java)
                        intent.putExtra("Name", name_reg.text.toString())
                        intent.putExtra("Email_reg", email_reg.text.toString())
                        intent.putExtra("Mobile_reg", mobile_reg.text.toString())
                        intent.putExtra("delivery_reg", delivery_reg.text.toString())
                        intent.putExtra("pass_reg", pass_reg.text.toString())
                        intent.putExtra("pass_confirm_reg", pass_confirm_reg.text.toString())
                        startActivity(intent)
                        Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show()
                    }
                }
            }

    }
    fun CheckAllFields():Boolean{
        if (name_reg.length()==0){
            name_reg.setError("this field is required")
            return false
        }
        if (name_reg.length()<=2){
            name_reg.setError("Name should be greater than 2")
            return false
        }
        if (email_reg.length()==0){
            email_reg.setError("this field is required")
            return false
        }
        if (mobile_reg.length()==0){
            mobile_reg.setError("this field is required")
            return false
        }
        if (mobile_reg.length()<10){
            mobile_reg.setError("Invalid")
            return false
        }
        if (delivery_reg.length()==0){
            delivery_reg.setError("this field is required")
            return false
        }
        if (pass_reg.length()==0){
            pass_reg.setError("this field is required")
            return false
        }
        if (pass_confirm_reg.length()==0){
            pass_confirm_reg.setError("this field is required")
            return false
        }
        if (pass_reg.text.toString()!= pass_confirm_reg.text.toString()){
            pass_confirm_reg.setError("Password not matched")
            return false
        }
        return true
    }
    override fun onPause() {
        super.onPause()
        val intent= Intent(this@Registration,MainActivity::class.java)
        startActivity(intent)
    }

}