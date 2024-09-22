package com.northcoders.recordshopandroid.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.northcoders.recordshopandroid.model.Album;
import com.northcoders.recordshopandroid.ui.mainactivity.MainActivity;
import com.northcoders.recordshopandroid.ui.mainactivity.MainActivityViewModel;

public class AddAlbumClickHandler {

    private Album album;
    private Context context;
    private MainActivityViewModel viewModel;

    public AddAlbumClickHandler(Album album,Context context, MainActivityViewModel viewModel ) {
        this.album = album;
        this.viewModel = viewModel;
        this.context = context;
    }

    public void onSubmitBtnClicked(View view){

        if(album.getAlbumName() == null || album.getReleaseYear() ==0 || album.getGenre() ==null || album.getAuthor()==null){
            Toast.makeText(context, "Field cannot be empty", Toast.LENGTH_SHORT).show();
        } else{
            Intent intent = new Intent(context, MainActivity.class);

            Album newAlbum = new Album(
                    album.getId(),
                    album.getAlbumName(),
                    album.getAuthor(),
                    album.getGenre(),
                    (int) album.getReleaseYear()
            );
            viewModel.addedAlbum(newAlbum);

            context.startActivity(intent);

        }
    }

    public void onBackButtonClicked(View view){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }


}