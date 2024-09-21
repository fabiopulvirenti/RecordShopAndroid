package com.northcoders.recordshopandroid.service;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

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

    public void addNewAlbum(Album albumToAdd){
        AlbumApiService apiService = RetrofitInstance.getService();
        Call<Album> call = apiService.addNewAlbum(albumToAdd);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(),
                        "Album added to database" ,
                        Toast.LENGTH_LONG).show();
                Log.i("POST RESponse code ", Integer.toString(response.code()));
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(),
                        "Unable to add album to database" ,
                        Toast.LENGTH_LONG).show();
                Log.e("POST REQ",t.getMessage());


            }
        });

    }

    public void updateAlbum(Long id, Album album){
        AlbumApiService apiService = RetrofitInstance.getService();
        Call<Album> call = apiService.updateAlbum(id,album);

        call.enqueue(
                new Callback<Album>() {
                    @Override
                    public void onResponse(Call<Album> call, Response<Album> response) {
                        Toast.makeText(application.getApplicationContext(),
                                "Album updated in the database" ,
                                Toast.LENGTH_LONG).show();
                        Log.i("PUT Response code ", Integer.toString(response.code()));
                    }

                    @Override
                    public void onFailure(Call<Album> call, Throwable t) {
                        Toast.makeText(application.getApplicationContext(),
                                "Unable to update the album in the database" ,
                                Toast.LENGTH_LONG).show();
                        Log.e("PUT REQ",t.getMessage());
                    }
                }
        );

    }

    public void deleteAlbum(Long id){
        AlbumApiService apiService = RetrofitInstance.getService();
        Call<String> call = apiService.deleteAlbum(id);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(application.getApplicationContext(),
                        "Album deleted from the database" ,
                        Toast.LENGTH_LONG).show();
                Log.i("DELETE Response code ", Integer.toString(response.code()));
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(),
                        "Unable to delete the album from the database" ,
                        Toast.LENGTH_LONG).show();
                Log.e("DELETE REQ",t.getMessage());

            }
        });
    }


}




















