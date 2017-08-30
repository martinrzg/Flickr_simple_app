package com.example.martinruiz.flickr.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PhotoInfo implements Serializable {
    @SerializedName("dateuploaded")
    private int date;
    private long isfavorite;
    private int views;
    private Owner owner;
    private Title title;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public long getIsfavorite() {
        return isfavorite;
    }

    public void setIsfavorite(long isfavorite) {
        this.isfavorite = isfavorite;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
