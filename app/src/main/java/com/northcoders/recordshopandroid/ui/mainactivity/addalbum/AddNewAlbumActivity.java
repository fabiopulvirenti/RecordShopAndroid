package com.northcoders.recordshopandroid.ui.mainactivity.addalbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.northcoders.recordshopandroid.R;
import com.northcoders.recordshopandroid.databinding.ActivityAddNewAlbumBinding;
import com.northcoders.recordshopandroid.model.Album;

public class AddNewAlbumActivity extends AppCompatActivity {

    private ActivityAddNewAlbumBinding BINDING;
    private AddAlbumClickHandler handler;
    private Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_album);

    }
}