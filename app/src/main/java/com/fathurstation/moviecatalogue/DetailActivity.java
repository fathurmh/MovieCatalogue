package com.fathurstation.moviecatalogue;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.fathurstation.moviecatalogue.model.Movie;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView tv_title;
    private TextView tv_synopsis;
    private ImageView iv_poster;
    private TextView tv_producer;
    private TextView tv_director;
    private TextView tv_writer;
    private TextView tv_cast;
    private TextView tv_distributor;
    private TextView tv_source;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tv_title = findViewById(R.id.detail_title);
        tv_synopsis = findViewById(R.id.detail_synopsis);
        iv_poster = findViewById(R.id.detail_poster);
        tv_producer = findViewById(R.id.detail_producer);
        tv_director = findViewById(R.id.detail_director);
        tv_writer = findViewById(R.id.detail_writer);
        tv_cast = findViewById(R.id.detail_cast);
        tv_distributor = findViewById(R.id.detail_distributor);
        tv_source = findViewById(R.id.detail_source);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        setDetailMovie(movie);
    }

    private void setDetailMovie(Movie movie) {
        String title = movie.getTitle();
        String synopsis = movie.getSynopsis();
        String producer = movie.getProducer();
        String director = movie.getDirector();
        String writer = movie.getWriter();
        String cast = movie.getCast();
        String distributor = movie.getDistributor();
        String source = movie.getSource();
        int poster = movie.getPoster();

        setTitle(title);
        tv_title.setText(title);
        tv_synopsis.setText(synopsis);
        Glide.with(this).load(poster).into(iv_poster);
        tv_producer.setText(producer);
        tv_director.setText(director);
        tv_writer.setText(writer);
        tv_cast.setText(cast);
        tv_distributor.setText(distributor);
        tv_source.setText(source);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
