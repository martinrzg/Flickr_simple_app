package com.example.martinruiz.flickr.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Sizes implements Serializable {
    public ArrayList<Size> getSize() {
        return size;
    }

    public void setSize(ArrayList<Size> size) {
        this.size = size;
    }

    private ArrayList<Size>size;
}
