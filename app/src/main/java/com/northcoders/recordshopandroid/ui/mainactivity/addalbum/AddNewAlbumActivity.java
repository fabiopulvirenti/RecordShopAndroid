package com.northcoders.recordshopandroid.ui.mainactivity.addalbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.recordshopandroid.R;
import com.northcoders.recordshopandroid.databinding.ActivityAddNewAlbumBinding;
import com.northcoders.recordshopandroid.model.Album;
import com.northcoders.recordshopandroid.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumActivity extends AppCompatActivity {

    private ActivityAddNewAlbumBinding binding;
    private AddAlbumClickHandler handler;
    private Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_album);

        album = new Album();

        binding = DataBindingUtil.setContentView(
                this,R.layout.activity_add_new_album
        );

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        handler = new AddAlbumClickHandler(album,this,viewModel);

        binding.setAlbum(album);

        binding.setClickHandler(handler);

    }
}