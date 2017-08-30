package com.example.martinruiz.flickr.models;

/**
 * Created by MartinRuiz on 8/29/2017.
 */

public class Category {

    private String name;
    private int reference;

    public Category(String name, int reference) {
        this.name = name;
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }
}
