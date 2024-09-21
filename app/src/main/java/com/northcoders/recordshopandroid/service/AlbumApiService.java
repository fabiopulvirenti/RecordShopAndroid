package com.northcoders.recordshopandroid.service;

import com.northcoders.recordshopandroid.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlbumApiService {

    @GET("albums")
    Call<List<Album>> getAllAlbums();

    @POST("albums")
    Call<Album> addNewAlbum(@Body Album album);

    @PUT("albums/{id}")
    Call<Album>updateAlbum(@Path("id") long id, @Body Album album);



}
