package com.northcoders.recordshopandroid.service;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.recordshopandroid.model.Album;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {


    private ArrayList<Album> albums = new ArrayList<>();
    private MutableLiveData<List<Album>> mutableLiveData= new MutableLiveData<>();
    public Application application;

    public AlbumRepository(Application application) {
        this.application = application;
    }


    public MutableLiveData<List<Album>>getMutableLiveData(){
        AlbumApiService albumApiService= RetrofitInstance.getService();
        Call<List<Album>> call = albumApiService.getAllAlbums();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albums =response.body();
                mutableLiveData.setValue(albums);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.e("GET request",t.getMessage());

            }
        });

        return mutableLiveData;

    }
}




















