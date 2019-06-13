package com.example.moviepi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

public class BrowseMoviesActivity extends AppCompatActivity {

    ListView listMovies;
    ArrayAdapter<String> adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_movies);

        listMovies = (ListView) findViewById(R.id.listMovies);
        listMovies.setAdapter(adapter);

        Spinner mySpinner = (Spinner) findViewById(R.id.spnTags);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<String> arrayMovies = new ArrayList<>();
                String text = parent.getSelectedItem().toString();

                if (text.equals("By Name"))
                    arrayMovies.addAll(Arrays.asList(getResources().getStringArray(R.array.Movies)));
                if (text.equals("By Director"))
                    arrayMovies.addAll(Arrays.asList(getResources().getStringArray(R.array.Directors)));
                if (text.equals("By Category"))
                    arrayMovies.addAll(Arrays.asList(getResources().getStringArray(R.array.Categories)));
                if (text.equals("By Actor"))
                    arrayMovies.addAll(Arrays.asList(getResources().getStringArray(R.array.Actors)));

                adapter = new ArrayAdapter<String>(
                        BrowseMoviesActivity.this,
                        android.R.layout.simple_list_item_1,
                        arrayMovies
                );

                listMovies.setAdapter(adapter);

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);


        MenuItem item = menu.findItem(R.id.listMovies);
        searchView = (SearchView) item.getActionView();

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
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
        } else {
            super.onBackPressed();
        }
    }
}
