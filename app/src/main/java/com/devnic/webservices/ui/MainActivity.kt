package com.devnic.webservices.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devnic.webservices.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_WebServices)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}