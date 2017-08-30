package com.example.martinruiz.flickr.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.martinruiz.flickr.API.API;
import com.example.martinruiz.flickr.API.APIServices.FlickrServices;
import com.example.martinruiz.flickr.R;
import com.example.martinruiz.flickr.models.PhotoGetInfoResponse;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.imageViewDetailPhoto) ImageView imageViewDetailPhoto;
    @BindView(R.id.textViewUsername) TextView textViewUsername;
    @BindView(R.id.textViewTitle) TextView textViewTitle;
    @BindView(R.id.textViewFavs) TextView textViewFavs;

    private FlickrServices flickrServices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        String id = getIntent().getExtras().getString("id");
        String url = getIntent().getExtras().getString("url");

        flickrServices = API.getApi().create(FlickrServices.class);

        Picasso.with(this).load(url).fit().into(imageViewDetailPhoto);

        Call<PhotoGetInfoResponse> infoResponseCall = flickrServices.getPhotoInfo(API.PHOTO_INFO,API.KEY,id, API.FORMAT,API.nojsoncallback);
        infoResponseCall.enqueue(new Callback<PhotoGetInfoResponse>() {
            @Override
            public void onResponse(Call<PhotoGetInfoResponse> call, Response<PhotoGetInfoResponse> response) {
                PhotoGetInfoResponse photoGetInfoResponse = response.body();
                String username = photoGetInfoResponse.getPhotoInfo().getOwner().getUsername();
                String title = photoGetInfoResponse.getPhotoInfo().getTitle().getContent();
                long favs = photoGetInfoResponse.getPhotoInfo().getIsfavorite();
                textViewUsername.setText(username);
                textViewTitle.setText(title);
                textViewFavs.setText(favs+"");
            }

            @Override
            public void onFailure(Call<PhotoGetInfoResponse> call, Throwable t) {
                Toast.makeText(DetailsActivity.this,"No internet service available",Toast.LENGTH_LONG).show();
            }
        });






    }
}
