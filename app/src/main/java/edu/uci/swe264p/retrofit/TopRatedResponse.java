package edu.uci.swe264p.retrofit;

import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopRatedResponse {

    @SerializedName("vote_average")
    private Float voteAverage;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("title")
    private String title;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("overview")
    private String overview;

    private RecyclerView recyclerView;

    static final String TAG = MainActivity.class.getSimpleName();
    static final String BASE_URL = "https://api.themoviedb.org/3/";
    static Retrofit retrofit = null;
    final static String API_KEY = "cb1473d8d9853e4ae7ef71dee1d4448f";

    public TopRatedResponse(Float voteAverage, String posterPath, String title, String releaseDate, String overview) {
        this.voteAverage = voteAverage;
        this.posterPath = posterPath;
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
    }

    public List<Movie> getResults() {
        // here, I should get a list of movies from server. 2 things might be helpful:
        // 2. study what the return values look like.
        // 3. study how to get one movie in the entry point.
        List<Movie> movies = new ArrayList<Movie>();

//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        MovieApiService movieApiService = retrofit.create(MovieApiService.class);
//        Call<TopRatedResponse> call = movieApiService.getTopRated("top_rated", API_KEY);
//        call.enqueue(new Callback<TopRatedResponse>() {
//            @Override
//            public void onResponse(Call<TopRatedResponse> call, Response<TopRatedResponse> response) {
//                List<Movie> listResponse = response.body().getResults();
//                movies.addAll(listResponse);
//                recyclerView = findViewById(R.id.rvMovieList);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                recyclerView.setAdapter(new MovieListAdapter(movies));
//            }
//            @Override
//            public void onFailure(Call<TopRatedResponse> call, Throwable throwable) {
//                Log.e(TAG, throwable.toString());
//            }
//        });


//        MovieApiService movieApiService = retrofit.create(MovieApiService.class);
//        Call<Movie> call = movieApiService.getMovie(603, API_KEY);
//        call.enqueue(new Callback<Movie>() {
//            @Override
//            public void onResponse(Call<Movie> call, Response<Movie> response) {
//                int[] ids = {R.id.txtTitle, R.id.txtReleaseDate, R.id.txtPoster,
//                        R.id.txtVote, R.id.txtOverview};
//                String[] values = {
//                        response.body().getTitle(),
//                        response.body().getReleaseDate(),
//                        response.body().getPosterPath(),
//                        response.body().getVoteAverage().toString(),
//                        response.body().getOverview()
//                };
//                TextView tv;
//                for (int i=0; i < ids.length; i++) {
//                    tv = findViewById(ids[i]);
//                    // for testing
//                    tv.setText(ids[i]);
//                    tv.setText(values[i]);
//                }
//            }
//            @Override
//            public void onFailure(Call<Movie> call, Throwable throwable) {
//                Log.e(TAG, throwable.toString());
//            }
//        });

        // might need a loop for these 2 steps below

        // retrieve the Movie object by retrofit
//        Movie aMovie = new Movie();
        // insert the movie object into the list.
//        movieList.add(aMovie);

        return movies;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOverview() {
        return overview;
    }

}
