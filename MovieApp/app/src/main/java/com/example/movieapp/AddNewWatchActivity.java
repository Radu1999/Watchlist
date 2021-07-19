package com.example.movieapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.adapters.ShowAdapter;
import com.example.movieapp.models.MovieDBResponse;
import com.example.movieapp.models.Show;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddNewWatchActivity extends AppCompatActivity {
    private static Retrofit mRetrofit;
    private static final String BASE_URL = "https://api.themoviedb.org";
    private final static int HTTP_OK = 200;
    private final static String API_KEY = "14a969ab28ec89f363ee56ee1b53383f";
    private RecyclerView showList;
    private List<Show> shows;
    private ShowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_watch);

        MovieService movieService = getRetrofitInstance().create(MovieService.class);
        Call<MovieDBResponse> callMovieAsync = movieService.getResponse(API_KEY, "avengers", 1);
       // Toast.makeText(AddNewWatchActivity.this,  callMovieAsync.request().toString(), Toast.LENGTH_SHORT).show();

        shows = new ArrayList<>();

        showList = findViewById(R.id.addNew_listRecyclerView);
        showList.hasFixedSize();

        RecyclerView.LayoutManager llm = new LinearLayoutManager(this);

        showList.setLayoutManager(llm);

        adapter = new ShowAdapter(shows);

        showList.setAdapter(adapter);


        callMovieAsync.enqueue(new Callback<MovieDBResponse> () {

            @Override
            public void onResponse(Call<MovieDBResponse> call, Response<MovieDBResponse> response) {
                if(response.code() == HTTP_OK) {
                    assert response.body() != null;
                    shows.addAll(response.body().getResults());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MovieDBResponse> call, Throwable t) {

                Toast.makeText(AddNewWatchActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static Retrofit getRetrofitInstance() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;
    }
}
