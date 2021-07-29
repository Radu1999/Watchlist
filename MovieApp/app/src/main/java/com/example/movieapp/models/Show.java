package com.example.movieapp.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.movieapp.converters.DateConverter;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

@Entity(tableName = "Show")
public class Show {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int showId;

    @ColumnInfo(name = "title")
    @SerializedName("original_title")
    private String title;

    @ColumnInfo(name = "synopsys")
    @SerializedName("overview")
    private String synopsys;

    @ColumnInfo(name = "rating")
    @SerializedName("vote_average")
    private double rating;

    @ColumnInfo(name = "imageUrl")
    @SerializedName("poster_path")
    private String imageUrl;


    @ColumnInfo(name = "date_watched")
    @TypeConverters(DateConverter.class)
    private Date date;


    public Show(int showId, String title, String synopsys, double rating, String imageUrl, Date date) {
        this.showId = showId;
        this.title = title;
        this.synopsys = synopsys;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getSynopsys() {
        return synopsys;
    }

    public void setSynopsys(String synopsys) {
        this.synopsys = synopsys;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
