package com.example.android_labs.labs3_Task4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.android_labs.R

class Activity1_task4: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity1_labs3_task4)
    }

    fun toSecond_t4(view: View) {
        val intent = Intent(this, Activity2_task4::class.java)
        startActivity(intent)
    }

    fun toFourth_t4(view: View) {
        val intent = Intent(this, Activity4_task4::class.java)
        startActivity(intent)
    }
}