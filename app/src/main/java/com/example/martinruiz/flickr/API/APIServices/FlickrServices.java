package com.example.martinruiz.flickr.API.APIServices;

import com.example.martinruiz.flickr.models.PhotoGetInfoResponse;
import com.example.martinruiz.flickr.models.PhotoSizeResponse;
import com.example.martinruiz.flickr.models.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by MartinRuiz on 8/29/2017.
 */

public interface FlickrServices {

    @GET("rest/")
    Call<SearchResponse> photoSearch(@Query("method") String method,@Query("api_key") String key, @Query("text") String text, @Query("per_page")
                        int perPage, @Query("format") String format, @Query("nojsoncallback") int jsonCallback);


    @GET("rest/")
    Call<PhotoSizeResponse> getPhotoSizes(@Query("method") String method,@Query("api_key") String key, @Query("photo_id") String photoId,
                                          @Query("format") String format, @Query("nojsoncallback") int jsonCallback );

    @GET("rest/")
    Call<PhotoGetInfoResponse> getPhotoInfo(@Query("method") String method, @Query("api_key") String key, @Query("photo_id") String photoId,
                                            @Query("format") String format,@Query("nojsoncallback") int jsonCallback);



}
