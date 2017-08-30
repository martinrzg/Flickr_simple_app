package com.example.martinruiz.flickr.models;

import java.io.Serializable;

public class Owner implements Serializable {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;
}
