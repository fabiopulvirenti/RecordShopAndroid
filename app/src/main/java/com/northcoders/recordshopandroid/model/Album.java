package com.northcoders.recordshopandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.recordshopandroid.BR;

public class Album extends BaseObservable implements Parcelable {

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


    protected Album(Parcel in) {
        id = in.readLong();
        albumName = in.readString();
        //author=in.readValue(Author.class.getClassLoader());
        genre = in.readString();
        releaseYear = in.readLong();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(albumName);
        //parcel.writeValue(author);
        parcel.writeString(genre);
        parcel.writeLong(releaseYear);
    }
}
