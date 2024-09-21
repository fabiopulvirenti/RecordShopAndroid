package com.northcoders.recordshopandroid.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class Author extends BaseObservable {

    private long id;

    private String authorName;

    public Author(long id, String authorName) {
        this.id = id;
        this.authorName = authorName;
    }

    public Author() {
    }

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;

    }

    @Bindable
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
