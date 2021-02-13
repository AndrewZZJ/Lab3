package edu.uci.swe264p.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MovieListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    static final String TAG = MainActivity.class.getSimpleName();
    static final String BASE_URL = "https://api.themoviedb.org/3/";
    static Retrofit retrofit = null;
    final static String API_KEY = "cb1473d8d9853e4ae7ef71dee1d4448f";
    List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_list);

        // how to change the content here so that it retrieves content with REST API?
        // this is a list. how to change a JSON or XML into things I want here...?
        // maybe I should use retrofit here?
        // idea: I should print the movie here. make the 20 movies a list, and print them out. So, how?
        // test: get one movie first.

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        MovieApiService movieApiService = retrofit.create(MovieApiService.class);
        Call<TopRatedResponse> call = movieApiService.getTopRated("top_rated", API_KEY);
        call.enqueue(new Callback<TopRatedResponse>() {
            @Override
            public void onResponse(Call<TopRatedResponse> call, Response<TopRatedResponse> response) {
                List<Movie> listResponse = response.body().getResults();
                movieList.addAll(listResponse);
                recyclerView = findViewById(R.id.rvMovieList);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(new MovieListAdapter(movieList));
            }
            @Override
            public void onFailure(Call<TopRatedResponse> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });


        // might not be helpful here.
//        List<String> programs = new ArrayList<String>(
//                Arrays.asList(
//                        // how to get Movie Strings here?
////                        response.body().getTitle(),
////                        response.body().getReleaseDate(),
////                        response.body().getPosterPath(),
////                        response.body().getVoteAverage().toString(),
////                        response.body().getOverview()
//                )
//        );
//
//        recyclerView = findViewById(R.id.rvPrograms);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new ProgramListAdapter(programs));
    }
}
