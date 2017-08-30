package com.example.martinruiz.flickr.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by MartinRuiz on 8/29/2017.
 */

public class PhotoGetInfoResponse implements Serializable {
    public PhotoInfo getPhotoInfo() {
        return photoInfo;
    }

    public void setPhotoInfo(PhotoInfo photoInfo) {
        this.photoInfo = photoInfo;
    }

    @SerializedName("photo")
    private PhotoInfo photoInfo;

}

