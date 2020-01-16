package com.example.morgan.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.morgan.R
import com.example.morgan.ui.home.HomeFragment
import com.example.morgan.ui.setting.SettingsActivity
import com.example.morgan.utils.Xit
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                Xit.openFragment(this, HomeFragment.newInstance(), null, R.id.llMiddle)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_account -> {
                Xit.openFragment(this, HomeFragment.newInstance(), "AccountFragment", R.id.llMiddle)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.llMiddle, HomeFragment.newInstance())
                .commitNow()
        }
    }

    override fun onResume() {
        super.onResume()
        supportFragmentManager.beginTransaction()
            .replace(R.id.llMiddle, HomeFragment.newInstance())
            .commitNow()
    }
}
