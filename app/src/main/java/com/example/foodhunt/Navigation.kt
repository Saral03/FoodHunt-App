package com.example.foodhunt

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.foodhunt.*
import com.google.android.material.navigation.NavigationView
import org.w3c.dom.Text

lateinit var toolbar:Toolbar
lateinit var navigation:NavigationView
lateinit var drawer_layout:DrawerLayout

lateinit var username: TextView
lateinit var mobile_drawer: TextView
lateinit var add: SharedPreferences
var PreviousMenuitem:MenuItem?=null
class Navigation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        toolbar = findViewById(R.id.toolbar)
        navigation = findViewById(R.id.navigation)
        drawer_layout = findViewById(R.id.drawer_layout)
        setmytoolbar()
        openHomePage()
        val actionBarDrawerToggle =
            ActionBarDrawerToggle(this@Navigation, drawer_layout, R.string.open, R.string.close)
        drawer_layout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navigation.setNavigationItemSelectedListener {
            if (PreviousMenuitem != null) {
                PreviousMenuitem?.isChecked = false
            }
            it.isCheckable = true
            it.isChecked = true
            PreviousMenuitem = it
            when (it.itemId) {
                R.id.home -> {
                    openHomePage()
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, Register_show_fragment())
                        .commit()
                    drawer_layout.closeDrawers()
                    supportActionBar?.title = "Profile"
                }
                R.id.faq -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, Faq_fragment())
                        .commit()
                    drawer_layout.closeDrawers()
                    supportActionBar?.title = "Frequently Asked Question"

                }
                R.id.logout -> {
                    drawer_layout.closeDrawers()
                    startActivity(Intent(this@Navigation, MainActivity::class.java))
                    sharedPreferences.edit().clear().apply()
                    finish()
                }
                R.id.fav ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, FavFragment())
                        .commit()
                    drawer_layout.closeDrawers()
                    supportActionBar?.title = "Favorites"

                }
            }
            return@setNavigationItemSelectedListener true
        }
        val convertView = LayoutInflater.from(this@Navigation).inflate(R.layout.drawer_header, null)
        username=convertView.findViewById(R.id.username)
        mobile_drawer=convertView.findViewById(R.id.mobile_drawer)
        add=this@Navigation.getSharedPreferences("FoodHunt", Context.MODE_PRIVATE)
        username.text= add.getString("Name",null)
        mobile_drawer.text=add.getString("Mobile_reg",null)
        navigation.addHeaderView(convertView)

    }

    fun setmytoolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Home"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            drawer_layout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)

    }

    fun openHomePage() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, HomePage())
            .commit()
        drawer_layout.closeDrawers()
        supportActionBar?.title = "Restaurants"
        navigation.setCheckedItem(R.id.home)
    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)
        when (frag) {
            !is HomePage -> openHomePage()
            else -> super.onBackPressed()
        }
    }
}