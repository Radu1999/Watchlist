package com.example.movieapp;

import com.example.movieapp.models.MovieDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
    @GET("/3/search/movie")
    Call<MovieDBResponse> getResponse(@Query("api_key") String api, @Query("query") String query, @Query("page") int page);
}
