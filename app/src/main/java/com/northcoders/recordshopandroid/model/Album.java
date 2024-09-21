package com.northcoders.recordshopandroid.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.recordshopandroid.BR;

public class Album extends BaseObservable {

    private long id;

    private String albumName;

    private Author author;

    private String genre;

    private long
            releaseYear;

    public Album(long id, String albumName, Author author, String genre, int releaseYear) {
        this.id = id;
        this.albumName = albumName;
        this.author = author;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public Album() {
        this.author = new Author(1, "");
    }


    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
        notifyPropertyChanged(BR.albumName);
    }

    @Bindable
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        notifyPropertyChanged(BR.author);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Bindable
    public long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }
}
