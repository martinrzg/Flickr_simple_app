package com.example.martinruiz.flickr.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MartinRuiz on 8/29/2017.
 */

public class PhotoSizeResponse implements Serializable{

    private Sizes sizes;
    private String stat;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }
}

