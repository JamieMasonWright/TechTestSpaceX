package com.javajj.lushTechTest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.javajj.lushTechTest.R
import com.javajj.lushTechTest.view.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment()
    }

    private fun loadFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_frame, HomeFragment())
            .commit()
    }
}