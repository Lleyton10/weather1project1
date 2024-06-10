package com.example.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_day_detail.*

class DayDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_detail)

        val day = intent.getStringExtra("day")
        val temperature = intent.getIntExtra("temperature", 0)
        val humidity = intent.getIntExtra("humidity", 0)
        val windSpeed = intent.getIntExtra("windSpeed", 0)

        tv_day_detail.text = day
        tv_temperature.text = "Temperature: $temperature°C"
        tv_humidity.text
