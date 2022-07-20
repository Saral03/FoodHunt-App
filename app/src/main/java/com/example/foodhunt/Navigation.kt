package com.example.foodhunt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

lateinit var toolbar:Toolbar
lateinit var navigation:NavigationView
lateinit var drawer_layout:DrawerLayout
class Navigation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        toolbar=findViewById(R.id.toolbar)
        navigation=findViewById(R.id.navigation)
        drawer_layout=findViewById(R.id.drawer_layout)
        val actionBarDrawerToggle=ActionBarDrawerToggle(this@Navigation, drawer_layout,R.string.open, R.string.close)
        drawer_layout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }
}