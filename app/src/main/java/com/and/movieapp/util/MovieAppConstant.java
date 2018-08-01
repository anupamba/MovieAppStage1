package com.and.movieapp.util;

/**
 * Created by ANUPAMBA
 */

public class MovieAppConstant {


    private static final String API_KEY = "7b574b6131e3f2e40fd6da81fc62d1ee";
    private static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/";
    private static final String API_ROOT_URI = "https://api.themoviedb.org/3/discover/movie?api_key=";
    private static final String LANGUAGE_OPTION  = "&language=en-US&sort_by";

    public static String getImageBaseUrl() {
        return IMAGE_BASE_URL;
    }

    public static String getApiKey() {
        return API_KEY;
    }

    public static String getApiRootUri() {
        return API_ROOT_URI+MovieAppConstant.getApiKey()+LANGUAGE_OPTION;
    }
}
