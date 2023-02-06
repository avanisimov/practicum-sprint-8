package ru.practicum.yandex

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "SPRINT_8"
    }

    private var timerTv: TextView? = null
    private var timerValue = 0
    private var timer: Timer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$this onCreate")
        setContentView(R.layout.activity_main)
        timerTv = findViewById(R.id.timer)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$this onStart")
        timer = Timer().apply {
            scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    timerValue++
                    Log.d(TAG, "$this tick timerValue=$timerValue")
                    timerTv?.post {
                        timerTv?.text = timerValue.toString()
                    }
                }
            }, 1000L, 1000L)
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
        timer?.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$this onDestroy")
    }
}