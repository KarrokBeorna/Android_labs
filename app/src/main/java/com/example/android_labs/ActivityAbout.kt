package com.example.android_labs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_labs.databinding.ActivityAboutBindingBinding

class ActivityAbout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAboutBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}