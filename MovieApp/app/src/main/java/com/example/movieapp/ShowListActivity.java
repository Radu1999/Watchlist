package com.example.movieapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.adapters.ShowAdapter;
import com.example.movieapp.models.Show;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ShowListActivity extends AppCompatActivity {

    private RecyclerView showList;
    private List<Show> shows;
    private ShowAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        shows = new ArrayList<>();

        shows.add(new Show("Avengers", "Iron man dies", 4.5));
        shows.add(new Show("Spiderman", "Peter Parker is a hero", 4.5));
        shows.add(new Show("Xmen", "Logan <3", 4));
        shows.add(new Show("Matrix", "Neo is cool", 4));
        shows.add(new Show("Star Wars: A new Hope", "Luke Skywalker yee", 4.5));
        shows.add(new Show("Star Wars: Revenge of the Sith", "Anakin is up to no good", 5));


        showList = findViewById(R.id.actShowList_listRecyclerView);
        showList.hasFixedSize();

        RecyclerView.LayoutManager llm = new LinearLayoutManager(this);

        showList.setLayoutManager(llm);

        adapter = new ShowAdapter(shows);

        showList.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.showlist_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.show_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }
}
