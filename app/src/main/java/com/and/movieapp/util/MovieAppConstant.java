package com.and.movieapp.util;

import com.and.movieapp.recyclerview.BuildConfig;

/**
 * Created by ANUPAMBA
 */

public class MovieAppConstant {


    private static final String API_KEY = "api_key="+ BuildConfig.API_KEY;
    private static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/";
    private static final String API_ROOT_URI = "https://api.themoviedb.org/3/movie/";
    private static final String API_DEFAULT = "discover/movie?";
    private static final String  API_TOP = "top_rated?";
    private static final String API_POPULAR = "popular?";
    private static final String LANGUAGE_OPTION  = "&language=en-US&page=1";

    public static String getImageBaseUrl() {
        return IMAGE_BASE_URL;
    }

    public static String getApiKey() {
        return API_KEY;
    }

    public static String getApiRootUri() {
        return API_ROOT_URI+API_TOP+MovieAppConstant.getApiKey()+LANGUAGE_OPTION;
    }

    public static String getApiRootUriTop() {
        return API_ROOT_URI+API_TOP+MovieAppConstant.getApiKey()+LANGUAGE_OPTION;
    }

    public static String getApiRootUriPopular() {
        return API_ROOT_URI+API_POPULAR+MovieAppConstant.getApiKey()+LANGUAGE_OPTION;
    }
}
