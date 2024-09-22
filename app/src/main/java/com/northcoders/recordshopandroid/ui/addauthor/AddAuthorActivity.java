package com.northcoders.recordshopandroid.ui.addauthor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.recordshopandroid.R;
import com.northcoders.recordshopandroid.databinding.ActivityAddAuthorBinding;
import com.northcoders.recordshopandroid.databinding.ActivityAddNewAlbumBinding;
import com.northcoders.recordshopandroid.model.Author;
import com.northcoders.recordshopandroid.ui.addalbum.AddAlbumClickHandler;
import com.northcoders.recordshopandroid.ui.mainactivity.MainActivityViewModel;

public class AddAuthorActivity extends AppCompatActivity {


    private ActivityAddAuthorBinding binding;
    private AddAuthorClickHandler handler;
    private Author author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_author);

        this.author = new Author();
        this.binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_add_author
        );

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        this.handler = new AddAuthorClickHandler(this.author, this, viewModel);

        this.binding.setAuthor(author);
        this.binding.setClickHandler(this.handler);
    }
}