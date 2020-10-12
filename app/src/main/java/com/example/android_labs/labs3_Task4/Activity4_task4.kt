package com.example.android_labs.labs3_Task4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.android_labs.R

class Activity4_task4: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity4_labs3_task4)
    }

    fun toFirstOnFourth_t4(view: View) {
        val intent = Intent(this, Activity1_task4::class.java)
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT))
    }
    fun toSecondOnFourth_t4(view: View) {
        val intent = Intent(this, Activity2_task4::class.java)
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY))
    }
    fun toThirdOnFourth_t4(view: View) {
        val intent = Intent(this, Activity3_task4::class.java)
        startActivity(intent)
    }

}