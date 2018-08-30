package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {WeatherEntry.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class SunshineDatabase extends RoomDatabase {

  private static final String DATABASE_NAME = "weather";
  private static SunshineDatabase instance;

  public abstract WeatherDao weatherDao();

  // Singleton
  public static SunshineDatabase getInstance(Context context) {
    if (instance != null) {
      instance = Room.databaseBuilder(context.getApplicationContext(), SunshineDatabase.class, SunshineDatabase.DATABASE_NAME).build();
    }
    return instance;
  }
}
