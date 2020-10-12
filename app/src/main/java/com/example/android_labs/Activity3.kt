package com.example.android_labs

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Activity3: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3)
    }

    // Для всех задач
    fun toSecondOnThird(view: View) {
        finish()
    }

    /**
        Задача 2

    fun toFirstOnThird(view: View) {
        setResult(Activity.RESULT_OK)
        finish()
    }*/

    fun toFirstOnThird(view: View) {
        val intent = Intent(this, Activity1::class.java)
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    }


}