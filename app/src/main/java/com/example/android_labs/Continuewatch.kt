package com.example.android_labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.continuewatch.*

val SECONDS_EL = "seconds_el"

class Continuewatch : AppCompatActivity() {
    var secondsElapsed: Int = 0
    var onTheScreen = false

    var backgroundThread = Thread {
        while (true) {
            Thread.sleep(1000)
            if (onTheScreen) {
                textSecondsElapsed.post {
                    textSecondsElapsed.text = "Seconds elapsed: " + secondsElapsed++
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.continuewatch)
        backgroundThread.start()
        Log.d("MyLifecycle", "onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MyLifecycle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyLifecycle", "onDestroy")
    }

    override fun onPause() {
        onTheScreen = false
        super.onPause()
        Log.d("MyLifecycle", "onPause")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MyLifecycle", "onStart")
    }

    override fun onResume() {
        onTheScreen = true
        super.onResume()
        Log.d("MyLifecycle", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MyLifecycle", "onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SECONDS_EL, secondsElapsed)
        super.onSaveInstanceState(outState)
        Log.d("MyLifecycle", "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        secondsElapsed = savedInstanceState.getInt(SECONDS_EL)
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("MyLifecycle", "onRestoreInstanceState")
    }
}