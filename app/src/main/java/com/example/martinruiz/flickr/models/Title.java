package com.example.martinruiz.flickr.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Title implements Serializable {
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @SerializedName("_content")

    private String content ;
}
