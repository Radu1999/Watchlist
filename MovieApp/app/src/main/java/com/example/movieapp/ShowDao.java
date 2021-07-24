package com.example.movieapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.movieapp.models.Show;

import java.util.List;

@Dao
public interface ShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertShow(Show show);

    @Query("SELECT * FROM SHOW")
    List<Show> getAllShows();


    @Delete
    void delete(Show show);
}
