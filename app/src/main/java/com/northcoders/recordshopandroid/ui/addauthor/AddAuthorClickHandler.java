package com.northcoders.recordshopandroid.ui.addauthor;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.northcoders.recordshopandroid.model.Author;
import com.northcoders.recordshopandroid.ui.addalbum.AddNewAlbumActivity;
import com.northcoders.recordshopandroid.ui.mainactivity.MainActivity;
import com.northcoders.recordshopandroid.ui.mainactivity.MainActivityViewModel;

import org.apache.commons.lang3.StringUtils;

public class AddAuthorClickHandler {

    private Author author;
    private Context context;
    private MainActivityViewModel viewModel;

    public AddAuthorClickHandler(Author author, Context context, MainActivityViewModel viewModel) {
        this.author = author;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onSubmitBtnClicked(View view){

        if(StringUtils.isEmpty(this.author.getAuthorName())){
            Toast.makeText(context, "Author name cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this.context, AddNewAlbumActivity.class);

            Author newAuthor = new Author(this.author.getId(), this.author.getAuthorName());
            viewModel.addAuthor(author);

            context.startActivity(intent);
        }
    }

    public void onBackButtonClicked(View view){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

}
