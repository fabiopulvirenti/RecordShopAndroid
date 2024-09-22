package com.northcoders.recordshopandroid.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.northcoders.recordshopandroid.model.Album;
import com.northcoders.recordshopandroid.ui.mainactivity.MainActivity;
import com.northcoders.recordshopandroid.ui.mainactivity.MainActivityViewModel;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class UpdateAlbumClickHandlers {


    private final Album album;
    private final Context context;
    private final MainActivityViewModel viewModel;
    private long albumId;

    public UpdateAlbumClickHandlers(Album album, Context context, MainActivityViewModel viewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = viewModel;

    }

    public void onSubmitBtnClicked(View view) {

        Album updateAlbum = new Album(
                this.album.getId(),
                this.album.getAlbumName(),
                this.album.getAuthor(),
                this.album.getGenre(),
                this.album.getReleaseYear()
        );


        if (StringUtils.isAnyEmpty(updateAlbum.getAlbumName(), updateAlbum.getGenre(), updateAlbum.getAuthor().getAuthorName())
                || updateAlbum.getReleaseYear() == 0) {
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this.context, MainActivity.class);

            albumId = album.getId();
            viewModel.updateAlbum(albumId, updateAlbum);

            this.context.startActivity(intent);
        }

    }

    public void onDeleteBtnClicked(View view) {

        Intent intent = new Intent(this.context, MainActivity.class);
        albumId = album.getId();
        this.viewModel.deleteAlbum(albumId);
        this.context.startActivity(intent);

    }

    public void onBackButtonClicked(View view) {
        Intent intent = new Intent(this.context, MainActivity.class);

        this.context.startActivity(intent);
    }
}
