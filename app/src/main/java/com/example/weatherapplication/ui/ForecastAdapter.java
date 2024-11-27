package com.example.weatherapplication.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapplication.R;
import com.example.weatherapplication.data.model.WeatherResponse;
import com.example.weatherapplication.utils.DateTimeUtils;

import java.util.ArrayList;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private List<WeatherResponse.Forecast> forecastList = new ArrayList<>();

    public void setForecastList(List<WeatherResponse.Forecast> forecastList){
        this.forecastList = forecastList != null ? forecastList : new ArrayList<>();
        notifyDataSetChanged();
    }
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent, false);
        return new ForecastViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        WeatherResponse.Forecast forecastItem = forecastList.get(position);
        holder.dateTextView.setText(DateTimeUtils.formatTimestamp(forecastItem.getDt()));
        holder.tempTextView.setText(forecastItem.getMain().getTemp() + "°C");
        holder.descriptionTextView.setText(forecastItem.getWeather().get(0).getDescription());
    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }

    public static class ForecastViewHolder extends RecyclerView.ViewHolder {

        TextView dateTextView;
        TextView tempTextView;
        TextView descriptionTextView;

        public ForecastViewHolder(View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.date);
            tempTextView = itemView.findViewById(R.id.temperature);
            descriptionTextView = itemView.findViewById(R.id.description);
        }
    }
}
