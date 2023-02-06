package ru.practicum.yandex

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "SPRINT_8"
        const val KEY_LAST_ON_STOP_TIME = "KEY_LAST_ON_STOP_TIME"
    }

    private var pinCode: TextView? = null
    private var lastOnStopTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$this onCreate")
        setContentView(R.layout.activity_main)
        pinCode = findViewById(R.id.pin_code)
        pinCode?.setOnClickListener {
            pinCode?.visibility = View.GONE
        }
        savedInstanceState?.getLong(KEY_LAST_ON_STOP_TIME)
    }

    override fun onStart() {
        super.onStart()
        if (System.currentTimeMillis() - lastOnStopTime > 5000L) {
            pinCode?.visibility = View.VISIBLE
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$this onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$this onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$this onStop")
        lastOnStopTime = System.currentTimeMillis()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$this onDestroy")
    }
}