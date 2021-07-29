package com.example.movieapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.movieapp.converters.DateConverter;
import com.example.movieapp.models.Show;

@Database(entities = {Show.class}, version = 3)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract ShowDao showDao();

    public static AppDatabase getAppDatabase(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "show-db").allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }

}
