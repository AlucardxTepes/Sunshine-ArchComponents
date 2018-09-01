package com.example.android.sunshine.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Date;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface WeatherDao {

  @Insert(onConflict = REPLACE)
  void bulkInsert(WeatherEntry... weatherEntries);

  @Query("SELECT * FROM weather WHERE date = :date")
  LiveData<WeatherEntry> findByDate(Date date);

  @Query("SELECT COUNT(id) FROM weather WHERE date >= :date")
  int countAllFutureWeather(Date date);

  @Query("DELETE FROM weather WHERE date <= :date")
  void deleteOldData(Date date);

  @Query("SELECT * FROM weather WHERE date >= :date")
  LiveData<List<WeatherEntry>> getCurrentWeatherForecasts(Date date);
}
