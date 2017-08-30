package com.example.martinruiz.flickr.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.example.martinruiz.flickr.API.API;
import com.example.martinruiz.flickr.API.APIServices.FlickrServices;
import com.example.martinruiz.flickr.R;
import com.example.martinruiz.flickr.adapters.GridPhotoAdapter;
import com.example.martinruiz.flickr.models.PhotoSizeResponse;
import com.example.martinruiz.flickr.models.SearchResponse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GridActivity extends AppCompatActivity {

    @BindView(R.id.gridView) GridView gridView;

    private FlickrServices flickrServices;
    private ArrayList<String> urls;
    private ArrayList<PhotoSizeResponse> photoSizeResponses;
    String category;
    private GridPhotoAdapter gridPhotoAdapter;
    SearchResponse searchResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        ButterKnife.bind(this);

        category = getIntent().getExtras().getString("category");
        urls = new ArrayList<>();
        photoSizeResponses= new ArrayList<>();
        flickrServices = API.getApi().create(FlickrServices.class);
        getImages();

        gridPhotoAdapter = new GridPhotoAdapter(GridActivity.this,R.layout.item_grid_photo,urls);
        gridView.setAdapter(gridPhotoAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(GridActivity.this,DetailsActivity.class);
                intent.putExtra("id",searchResponses.getPhotos().getPhoto().get(i).getId());
                intent.putExtra("url",urls.get(i));
                startActivity(intent);
            }
        });



    }



    public void getImages(){
        Call<SearchResponse> searchResponse = flickrServices.photoSearch(API.SEARCH_PHOTO,API.KEY,category,API.MAX,API.FORMAT,API.nojsoncallback);

        searchResponse.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if(response.code()==200){
                    SearchResponse searchResponse = response.body();
                    searchResponses = searchResponse;
                    for (int i = 0; i < searchResponse.getPhotos().getPhoto().size(); i++) {
                        String id = searchResponse.getPhotos().getPhoto().get(i).getId();
                        Call<PhotoSizeResponse> photoSizeResponse = flickrServices.getPhotoSizes(API.PHOTO_SIZE,API.KEY,id,API.FORMAT,API.nojsoncallback);
                        photoSizeResponse.enqueue(new Callback<PhotoSizeResponse>() {
                            @Override
                            public void onResponse(Call<PhotoSizeResponse> call, Response<PhotoSizeResponse> response) {
                                PhotoSizeResponse photoSizeResponse = response.body();
                                photoSizeResponses.add(photoSizeResponse);
                                String url = photoSizeResponse.getSizes().getSize().get(5).getSource();
                                System.out.println("AGREGANDOOOOOOOO URL: "+url);
                                urls.add(url);
                                gridPhotoAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onFailure(Call<PhotoSizeResponse> call, Throwable t) {
                                Toast.makeText(GridActivity.this,"No internet service available",Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }

            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Toast.makeText(GridActivity.this,"No internet service available",Toast.LENGTH_LONG).show();
            }
        });
    }
}
