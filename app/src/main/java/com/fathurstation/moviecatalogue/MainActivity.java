package com.fathurstation.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.fathurstation.moviecatalogue.adapter.MovieAdapter;
import com.fathurstation.moviecatalogue.model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);

        ListView listView = findViewById(R.id.list_movie);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        getMovies();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        showSelectedMovie(movies.get(i));
    }

    private void getMovies() {
        String[] dataTitle = getResources().getStringArray(R.array.data_title);
        String[] dataSynopsis = getResources().getStringArray(R.array.data_synopsis);
        TypedArray dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        String[] dataProducer = getResources().getStringArray(R.array.data_producer);
        String[] dataDirector = getResources().getStringArray(R.array.data_director);
        String[] dataWriter = getResources().getStringArray(R.array.data_writer);
        String[] dataCast = getResources().getStringArray(R.array.data_cast);
        String[] dataDistributor = getResources().getStringArray(R.array.data_distributor);
        String[] dataSource = getResources().getStringArray(R.array.data_source);

        movies = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(dataTitle[i]);
            movie.setSynopsis(dataSynopsis[i]);
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setProducer(dataProducer[i]);
            movie.setDirector(dataDirector[i]);
            movie.setWriter(dataWriter[i]);
            movie.setCast(dataCast[i]);
            movie.setDistributor(dataDistributor[i]);
            movie.setSource(dataSource[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
        dataPoster.recycle();
    }

    private void showSelectedMovie(Movie movie) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_MOVIE, movie);
        Toast.makeText(MainActivity.this, movie.getTitle(), Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}
