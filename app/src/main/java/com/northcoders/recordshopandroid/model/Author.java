package com.northcoders.recordshopandroid.model;

import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class Author {

    private long id;

    private String authorName;

    public Author(long id, String authorName) {
        this.id = id;
        this.authorName = authorName;
    }

    public Author() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;

    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
