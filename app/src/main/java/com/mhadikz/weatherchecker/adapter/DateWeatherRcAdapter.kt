package com.mhadikz.weatherchecker.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mhadikz.weatherchecker.R
import com.mhadikz.weatherchecker.model.DateWeather

class DateWeatherRcAdapter(listItems: List<DateWeather>) : GenericAdapter<DateWeather>(listItems) {
    override fun getLayoutId(position: Int, obj: DateWeather): Int {
        return R.layout.item_unselected_day_temperature
    }

    override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
        return DateWeatherVH(view)
    }

    class DateWeatherVH(itemView: View) : RecyclerView.ViewHolder(itemView), Binder<DateWeather> {

        var txtTemperatureNumber: TextView
        var txtDate: TextView

        init {
            txtTemperatureNumber = itemView.findViewById(R.id.txtTemperatureNumber)
            txtDate = itemView.findViewById(R.id.txtDate)
        }

        override fun bind(dataWeather: DateWeather) {
            txtTemperatureNumber.text = dataWeather.temperature.toString()
            txtDate.text = dataWeather.date
        }
    }
}