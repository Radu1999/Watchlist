package com.example.movieapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.room.Update;

import com.example.movieapp.converters.DateConverter;
import com.example.movieapp.models.Show;

import java.util.List;

@Dao
@TypeConverters(DateConverter.class)
public interface ShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertShow(Show show);

    @Query("SELECT * FROM SHOW")
    List<Show> getAllShows();


    @Delete
    void delete(Show show);

    @Update
    void update(Show show);
}
