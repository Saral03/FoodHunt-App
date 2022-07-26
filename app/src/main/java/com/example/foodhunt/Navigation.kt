package com.example.foodhunt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

lateinit var toolbar:Toolbar
lateinit var navigation:NavigationView
lateinit var drawer_layout:DrawerLayout
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