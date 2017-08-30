package com.example.martinruiz.flickr.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by MartinRuiz on 8/29/2017.
 */

public class SearchResponse implements Serializable{
    private Photos photos;

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }
}

