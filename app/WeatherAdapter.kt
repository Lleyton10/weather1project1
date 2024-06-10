package com.example.weatherapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeatherAdapter(private val weatherList: List<Weather>) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDay: TextView = itemView.findViewById(R.id.tv_day)
        val tvTemperature: TextView = itemView.findViewById(R.id.tv_temperature)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_day, parent, false)
        return WeatherViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val currentItem = weatherList[position]
        holder.tvDay.text = currentItem.day
        holder.tvTemperature.text = "${currentItem.temperature}°C"

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DayDetailActivity::class.java).apply {
                putExtra("day", currentItem.day)
                putExtra("temperature", currentItem.temperature)
                putExtra("humidity", currentItem.humidity)
                putExtra("windSpeed", currentItem.windSpeed)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = weatherList.size
}
