package ru.practicum.yandex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.practicum.yandex.R.layout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
    }
}