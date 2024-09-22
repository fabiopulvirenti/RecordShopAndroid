package com.northcoders.recordshopandroid.service;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.recordshopandroid.model.Album;
import com.northcoders.recordshopandroid.model.Author;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorRepository {

    private final Application application;
    private final MutableLiveData<List<Author>> mutableLiveData= new MutableLiveData<>();

    public AuthorRepository(Application application) {
        this.application = application;
    }


    public MutableLiveData<List<Author>> getAllAuthors() {
        AuthorApiService apiService = RetrofitInstance.getAuthorApiService();
        Call<List<Author>> listAuthorsCall = apiService.getAllAuthors();

        listAuthorsCall.enqueue(new Callback<List<Author>>() {
            @Override
            public void onResponse(Call<List<Author>> call, Response<List<Author>> response) {
                List<Author> authorList = response.body();
                mutableLiveData.setValue(authorList);
            }

            @Override
            public void onFailure(Call<List<Author>> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(),
                        "Unable to retrieve the list of Authors from the database" ,
                        Toast.LENGTH_LONG).show();
                Log.e("GET REQ",t.getMessage());
            }
        });

        return mutableLiveData;

    }

    public void addNewAuthor(Author author){
        AuthorApiService apiService = RetrofitInstance.getAuthorApiService();
        Call<Author> authorCall = apiService.addNewAuthor(author);

        authorCall.enqueue(new Callback<Author>() {
            @Override
            public void onResponse(Call<Author> call, Response<Author> response) {
                Toast.makeText(application.getApplicationContext(),
                        "Author added to database" ,
                        Toast.LENGTH_LONG).show();
                Log.i("POST Response code ", Integer.toString(response.code()));
            }

            @Override
            public void onFailure(Call<Author> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(),
                        "Unable to add the Author to the database" ,
                        Toast.LENGTH_LONG).show();
                Log.e("POST Response",t.getMessage());
            }
        });


    }


}
