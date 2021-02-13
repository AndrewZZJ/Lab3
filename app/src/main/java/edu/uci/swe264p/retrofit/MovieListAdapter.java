package edu.uci.swe264p.retrofit;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;


// Basically, change type from "String" to "Movie", change PorgramListAdapter to MovieListAdapter.
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private List<Movie> mData;
    static final String BASE_IMG_URL = "http://image.tmdb.org/t/p/w500/";

    MovieListAdapter(List<Movie> data) {
        this.mData = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        Movie movie;

        ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tvProgramName);
            // how to initiate my movie?
//            movie = ;
        }
    }

    @Override
    public MovieListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.program_row, parent, false);
        return new MovieListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.ViewHolder holder, int position) {
        // this part sets program strings originally. Maybe I should try to set movie info here.
//        Movie program = mData.get(position);
//        holder.tv.setText(program);

        Movie aMovie = mData.get(position);

        // get image by Picasso
        String imgURL = BASE_IMG_URL + aMovie.getPosterPath();
        // not sure about this cast is correct or not.
        // one more problem: I should put the image into a imageView, so how?
//        Picasso.get().load(imgURL).into((Target) holder.movie);
        // idea 2: use the movie I just get.
        Picasso.get().load(imgURL).into((Target) aMovie);
//        Picasso.get().load(imgURL).into(aMovie.getOverview());
//        holder.tv.setText(aMovie.getPosterPath());

        holder.tv.setText(aMovie.getTitle());
        holder.tv.setText(aMovie.getReleaseDate());
        holder.tv.setText(aMovie.getVoteAverage().toString());
        holder.tv.setText(aMovie.getOverview());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
