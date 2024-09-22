package com.northcoders.recordshopandroid.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.northcoders.recordshopandroid.model.Album;
import com.northcoders.recordshopandroid.model.Author;
import com.northcoders.recordshopandroid.service.AlbumRepository;
import com.northcoders.recordshopandroid.service.AuthorRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private AlbumRepository albumRepository;
    private AuthorRepository authorRepository;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
        this.authorRepository = new AuthorRepository(application);
    }

    public LiveData<List<Album>> getAllAlbums(){
        return albumRepository.getMutableLiveData();
    }

    public void addedAlbum(Album album){
        albumRepository.addNewAlbum(album);
    }

    public void updateAlbum(Long id,Album album){
        albumRepository.updateAlbum(id,album);
    }

    public void deleteAlbum(Long id){
        albumRepository.deleteAlbum(id);
    }


    public LiveData<List<Author>> getAllAuthors(){
        return this.authorRepository.getAllAuthors();
    }

    public void addAuthor(Author author){
            this.authorRepository.addNewAuthor(author);
    }

}
