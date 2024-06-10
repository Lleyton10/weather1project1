package com.example.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val weatherList = listOf(
        Weather("Monday", 22, 60, 15),
        Weather("Tuesday", 24, 55, 10),
        Weather("Wednesday", 19, 65, 20),
        Weather("Thursday", 21, 50, 12),
        Weather("Friday", 23, 58, 14),
        Weather("Saturday", 25, 60, 18),
        Weather("Sunday", 20, 62, 16)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val averageTemperature = weatherList.map { it.temperature }.average()
        tv_average_temperature.text = "Average Temperature: ${"%.1f".format(averageTemperature)}°C"

        rv_weather.adapter = WeatherAdapter(weatherList)
        rv_weather.layoutManager = LinearLayoutManager(this)
        rv_weather.setHasFixedSize(true)
    }
}
