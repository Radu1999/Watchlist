package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onShowListClick(View view) {
        Intent intent = new Intent(this, ShowListActivity.class);
        startActivity(intent);
    }

    public void onAddNewWatchClick(View view) {
        Intent intent = new Intent(this, AddNewWatchActivity.class);
        startActivity(intent);
    }
}