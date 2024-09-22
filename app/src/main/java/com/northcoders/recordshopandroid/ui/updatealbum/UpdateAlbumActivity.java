package com.northcoders.recordshopandroid.ui.updatealbum;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.recordshopandroid.R;
import com.northcoders.recordshopandroid.databinding.ActivityUpdateAlbumBinding;
import com.northcoders.recordshopandroid.model.Album;
import com.northcoders.recordshopandroid.model.Author;
import com.northcoders.recordshopandroid.model.Genre;
import com.northcoders.recordshopandroid.ui.addalbum.AddAlbumClickHandler;
import com.northcoders.recordshopandroid.ui.mainactivity.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class UpdateAlbumActivity extends AppCompatActivity {

    public static final String ALBUM_KEY ="album";

    private ActivityUpdateAlbumBinding binding;
    private UpdateAlbumClickHandlers handler;
    private Album album;


    private ArrayAdapter authorSpinnerAdapter;
    private ArrayAdapter genreSpinnerAdapter;
    private List<Author> authorList=new ArrayList<>();


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

        //Spinner Genre
        Spinner genreSpinner = findViewById(R.id.spinnerGenre);
        genreSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Genre.values());
        genreSpinner.setAdapter(genreSpinnerAdapter);

        //Spinner Authors
        Spinner editAuthorSpinner = findViewById(R.id.spinnerEditAuthor);
        authorSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, authorList);
        editAuthorSpinner.setAdapter(authorSpinnerAdapter);

        populateAuthorsList(viewModel);


    }

    private void populateAuthorsList(MainActivityViewModel viewModel){
        viewModel.getAllAuthors().observe(this, new Observer<List<Author>>() {
            @Override
            public void onChanged(List<Author> authors) {
                authorList.clear();
                authorList.addAll(authors);
                authorList.add(new Author(0, "... Add author"));

                authorSpinnerAdapter.notifyDataSetChanged();
            }
        });
    }
}