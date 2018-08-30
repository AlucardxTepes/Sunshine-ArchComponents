package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Date;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface WeatherDao {

  @Insert(onConflict = REPLACE)
  void bulkInsert(WeatherEntry... weatherEntries);

  @Query("SELECT * FROM weather WHERE date = :date")
  WeatherEntry findByDate(Date date);

}
