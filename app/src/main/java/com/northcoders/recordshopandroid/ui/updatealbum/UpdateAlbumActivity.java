package com.northcoders.recordshopandroid.ui.updatealbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.recordshopandroid.R;
import com.northcoders.recordshopandroid.databinding.ActivityUpdateAlbumBinding;
import com.northcoders.recordshopandroid.model.Album;
import com.northcoders.recordshopandroid.ui.addalbum.AddAlbumClickHandler;
import com.northcoders.recordshopandroid.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumActivity extends AppCompatActivity {

    public static final String ALBUM_KEY ="album";

    private ActivityUpdateAlbumBinding binding;
    private UpdateAlbumClickHandlers handler;
    private Album album;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_update_album);

        album = getIntent().getParcelableExtra(ALBUM_KEY,Album.class);
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_update_album
        );

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        handler = new UpdateAlbumClickHandlers(album,this,viewModel);

        binding.setAlbum(album);

        binding.setClickHandler(handler);

    }
}