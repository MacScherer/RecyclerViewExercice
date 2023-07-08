package com.example.recyclerviewexercice.activity.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerviewexercice.R;
import com.example.recyclerviewexercice.activity.activity.RecyclerItemClickListener;
import com.example.recyclerviewexercice.activity.activity.adapter.AdapterMovie;
import com.example.recyclerviewexercice.activity.activity.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //LIST MOVIE
        this.createMovie();

        // CONFIG ADAPTER
        AdapterMovie adapter = new AdapterMovie(movieList);

        //CONFIG RECYCLER VIEW
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); // OPTIMIZE SIZE
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        // CLICK EVENT
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Movie movie = movieList.get(position);
                Toast.makeText(MainActivity.this, movie.getMovieTitle() + ": CLICKED", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Movie movie = movieList.get(position);
                Toast.makeText(MainActivity.this, movie.getMovieTitle() + ": LONG CLICKED", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }
        ));


    }

    public void createMovie(){
        Movie movie = new Movie("The Dark Knight", "Action", "2008");
        this.movieList.add(movie);

        movie = new Movie("Inception", "Sci-Fi", "2010");
        this.movieList.add(movie);

        movie = new Movie("Pulp Fiction", "Crime", "1994");
        this.movieList.add(movie);

        movie = new Movie("The Shawshank Redemption", "Drama", "1994");
        this.movieList.add(movie);

        movie = new Movie("The Matrix", "Sci-Fi", "1999");
        this.movieList.add(movie);

        movie = new Movie("The Godfather", "Crime", "1972");
        this.movieList.add(movie);

        movie = new Movie("Forrest Gump", "Drama", "1994");
        this.movieList.add(movie);

        movie = new Movie("The Lord of the Rings: The Fellowship of the Ring", "Fantasy", "2001");
        this.movieList.add(movie);

        movie = new Movie("Interstellar", "Sci-Fi", "2014");
        this.movieList.add(movie);

        movie = new Movie("Fight Club", "Drama", "1999");
        this.movieList.add(movie);
    }
}