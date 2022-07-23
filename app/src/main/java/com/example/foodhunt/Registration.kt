package com.example.foodhunt

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.ButtonBarLayout
import androidx.fragment.app.FragmentTransaction

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
        name_reg=findViewById(R.id.name_reg)
        email_reg=findViewById(R.id.email_reg)
        mobile_reg=findViewById(R.id.mobile_reg)
        delivery_reg=findViewById(R.id.delivery_reg)
        pass_reg=findViewById(R.id.pass_reg)
        pass_confirm_reg=findViewById(R.id.pass_confirm_reg)
        but_reg=findViewById(R.id.but_reg)
        
        but_reg.setOnClickListener {
            var isAllFieldChecked=false
            isAllFieldChecked=CheckAllFields()
            if (isAllFieldChecked) {
                openFragment()
                Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "some problem occured", Toast.LENGTH_SHORT).show()
            }
        }
//                        val bundle=Bundle()
//                        bundle.putString("Name",name_reg.text.toString())
//                        bundle.putString("Email_reg",email_reg.text.toString())
//                        bundle.putString("Mobile_reg",mobile_reg.text.toString())
//                        bundle.putString("delivery_reg",delivery_reg.text.toString())
//                        bundle.putString("pass_reg",pass_reg.text.toString())
//                        bundle.putString("pass_confirm_reg",pass_confirm_reg.text.toString())
//                        val fragment=Register_show_fragment()
//                        fragment.arguments=bundle

//                        fragmentManager?.beginTransaction()?.replace(R.id.frame_reg,fragment)?.commit()
//                    val intent = Intent(this@Registration,Register_show_fragment::class.java)
//                    intent.putExtra("Name", name_reg.text.toString())
//                    intent.putExtra("Email_reg", email_reg.text.toString())
//                    intent.putExtra("Mobile_reg", mobile_reg.text.toString())
//                    intent.putExtra("delivery_reg", delivery_reg.text.toString())
//                    intent.putExtra("pass_reg", pass_reg.text.toString())
//                    intent.putExtra("pass_confirm_reg", pass_confirm_reg.text.toString())
//                    startActivity(intent)
        
    }
    fun openFragment(){
        val fragment  = Register_show_fragment()
        val bundle=Bundle()
        bundle.putString("Name",name_reg.text.toString())
        bundle.putString("Email_reg",email_reg.text.toString())
        bundle.putString("Mobile_reg",mobile_reg.text.toString())
        bundle.putString("delivery_reg",delivery_reg.text.toString())
        bundle.putString("pass_reg",pass_reg.text.toString())
        bundle.putString("pass_confirm_reg",pass_confirm_reg.text.toString())
        fragment.arguments=bundle
        val intent=Intent(this@Registration,MainActivity::class.java)
        //supportFragmentManager.beginTransaction().replace(R.id.frame_reg,fragment).commit()
        startActivity(intent)


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
}