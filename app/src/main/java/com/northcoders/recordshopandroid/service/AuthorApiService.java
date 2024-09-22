package com.northcoders.recordshopandroid.service;

import com.northcoders.recordshopandroid.model.Author;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AuthorApiService {

    @GET("authors")
    Call<List<Author>> getAllAuthors();

    @POST("authors")
    Call<Author> addNewAuthor(@Body Author author);
}
