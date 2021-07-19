package com.example.movieapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDBResponse {
    @SerializedName("results")
    private List<Show> results;

    public MovieDBResponse(List<Show> results) {
        this.results = results;
    }

    public List<Show> getResults() {
        return results;
    }

    public void setResults(List<Show> results) {
        this.results = results;
    }
}
