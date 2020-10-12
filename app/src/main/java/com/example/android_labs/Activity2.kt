package com.example.android_labs

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Activity2: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)
    }

    // Для всех задач
    fun toFirst(view: View) {
        finish()
    }

    /**
        Задача 2

     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SEC_ACT) {
            if (resultCode == Activity.RESULT_OK) {
                finish()
            }
        }
    }

    val SEC_ACT = 0

    fun toThird(view: View) {
        val intent = Intent(this, Activity3::class.java)
        startActivityForResult(intent, SEC_ACT)
    }*/


    // Задача 3
    fun toThird(view: View) {
        startActivity(Intent("com.example.android_labs.Activity3"))
    }
}