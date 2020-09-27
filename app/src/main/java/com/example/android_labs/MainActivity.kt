package com.example.android_labs

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.task2_1.*

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task2_1)
    }

    var count = 0

    fun invis(view: View) {
        val iv = findViewById<ImageView>(R.id.imageView7)
        if (count % 2 == 1) {
            iv.visibility = View.GONE
            count++
        } else {
            imageView7.visibility = View.VISIBLE
            count++
        }
    }
}