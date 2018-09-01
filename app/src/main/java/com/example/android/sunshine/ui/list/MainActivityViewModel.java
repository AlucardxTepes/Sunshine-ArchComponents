package com.example.android.sunshine.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.sunshine.data.SunshineRepository;
import com.example.android.sunshine.data.database.WeatherEntry;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

  private LiveData<List<WeatherEntry>> mWeatherForecast;

  public MainActivityViewModel(SunshineRepository repository) {
    mWeatherForecast = repository.getWeatherForecast();
  }

  public LiveData<List<WeatherEntry>> getWeatherForecast() {
    return mWeatherForecast;
  }
}
