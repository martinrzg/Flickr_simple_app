package com.example.martinruiz.flickr.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MartinRuiz on 8/28/2017.
 */

public class API {
    public static final String BASE_URL = "https://api.flickr.com/services/";
    public static final String KEY = "fb4c51c88edc46974f11be863f159555";
    public static final int MAX = 12;
    public static final String FORMAT = "json";
    public static final int nojsoncallback = 1;

    public static final String SEARCH_PHOTO = "flickr.photos.search";
    public static final String PHOTO_SIZE = "flickr.photos.getSizes";
    public static final String PHOTO_INFO = "flickr.photos.getInfo";




    private static Retrofit retrofit = null;

    public static Retrofit getApi(){
        if(retrofit == null){
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
