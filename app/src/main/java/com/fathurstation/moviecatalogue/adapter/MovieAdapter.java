package com.fathurstation.moviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fathurstation.moviecatalogue.R;
import com.fathurstation.moviecatalogue.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder {
        private TextView title;
        private TextView synopsis;
        private ImageView poster;

        ViewHolder(View view) {
            title = view.findViewById(R.id.tv_title);
            synopsis = view.findViewById(R.id.tv_synopsis);
            poster = view.findViewById(R.id.iv_poster);
        }

        void bind(Movie movie) {
            title.setText(movie.getTitle());
            synopsis.setText(movie.getSynopsis());
            Glide.with(context).load(movie.getPoster()).into(poster);
        }
    }
}
