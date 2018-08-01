package com.and.movieapp.util;

import com.and.movieapp.model.MovieDto;
import com.and.movieapp.recyclerview.MovieAdapter;
import com.and.movieapp.util.JsonUtils;
import com.and.movieapp.util.MovieAppConstant;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by ANUPAMBA.
 */



public class MovieAPIUtil1 {


    String strJson = null;

    public List<MovieDto> callDefaultMovieSearch() throws Exception{

        String urlParam = "=popularity.desc&include_adult=false&include_video=false&page=1";

       //return JsonUtils.parseApiResponseJson( new RestAPITask(strJson).execute(urlParam).toString());


        return JsonUtils.parseApiResponseJson(null);
    }

    private BufferedReader externalAPICall (String urlParam)  throws Exception{

        URL url = new URL(MovieAppConstant.getApiRootUri()+ urlParam);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        return new BufferedReader(new InputStreamReader((con.getInputStream())));
    }


    private class RestAPITask extends AsyncTask<String, Void, String> {

        String json;

        RestAPITask(String json) {
               this. json = json;
        }

        protected String doInBackground(String... urls) {
            try {
                strJson = externalAPICall(urls[0]).readLine().toString();
                return strJson;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String json) {
            strJson = json;
        }
    }

}
