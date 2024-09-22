package com.northcoders.recordshopandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Author extends BaseObservable implements Parcelable {

    private long id;

    private String authorName;

    public Author(long id, String authorName) {
        this.id = id;
        this.authorName = authorName;
    }

    public Author() {
    }

    protected Author(Parcel in) {
        id = in.readLong();
        authorName = in.readString();
    }

    public static final Creator<Author> CREATOR = new Creator<Author>() {
        @Override
        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        @Override
        public Author[] newArray(int size) {
            return new Author[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(authorName);
    }

    @NonNull
    @Override
    public String toString() {
        return this.getAuthorName();
    }
}
