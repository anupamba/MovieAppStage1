package com.and.movieapp.recyclerview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.and.movieapp.model.MovieDto;
import com.and.movieapp.util.MovieAppConstant;

import java.io.InputStream;


public class DetailActivity extends AppCompatActivity {

    public static final String JSON_BLOCK = "json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        MovieDto objMovieDto= new MovieDto();
        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        objMovieDto = (MovieDto)intent.getSerializableExtra(JSON_BLOCK);
        if (objMovieDto == null) {
            closeOnError();
            return;
        }

        new DownloadImageTask((ImageView) findViewById(R.id.poster_path_img)).execute(MovieAppConstant.getImageBaseUrl()+objMovieDto.getBackdrop_path());

        populateUI(objMovieDto);

        setTitle(objMovieDto.getTitle());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(MovieDto objMovieDto) {

        TextView title_tv = findViewById(R.id.title_tv);
        title_tv.setText(null != objMovieDto.getTitle()  ? objMovieDto.getTitle() : "Not Available");

        TextView original_title_tv = findViewById(R.id.original_title_tv);
        original_title_tv.setText(null != objMovieDto.getOriginal_title()  ? objMovieDto.getOriginal_title() : "Not Available");

        TextView overview_tv = findViewById(R.id.overview_tv);
        overview_tv.setText(null != objMovieDto.getOverview()  ? objMovieDto.getOverview() : "Not Available");

        TextView original_language_tv = findViewById(R.id.original_language_tv);
        original_language_tv.setText(null != objMovieDto.getOriginal_language()  ? objMovieDto.getOriginal_language() : "Not Available");

        TextView popularity_tv = findViewById(R.id.popularity_tv);
        popularity_tv.setText(Float.toString(objMovieDto.getPopularity()));

        TextView adult_tv = findViewById(R.id.adult_tv);
        adult_tv.setText( objMovieDto.isAdult() ? "True" : "False");

        TextView video_tv = findViewById(R.id.video_tv);
        video_tv.setText( objMovieDto.isVideo() ? "True" : "False");

        TextView vote_count_tv = findViewById(R.id.vote_count_tv);
        vote_count_tv.setText(Integer.toString(objMovieDto.getVote_count()));

        TextView release_date_tv = findViewById(R.id.release_date_tv);
        release_date_tv.setText(null != objMovieDto.getRelease_date()  ? objMovieDto.getRelease_date() : "Not Available");

        TextView geners_tv = findViewById(R.id.genre_ids_tv);
        geners_tv.setText(null != objMovieDto.getGenre_ids()  ? objMovieDto.getGenre_ids().toString() : "Not Available");

    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
