package com.northcoders.recordshopandroid.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.northcoders.recordshopandroid.ui.mainactivity.addalbum.AddNewAlbumActivity;

public class MainActivityClickHandler {

    Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void onFABClicked(View view){

        Intent intent = new Intent(view.getContext(), AddNewAlbumActivity.class);

        context.startActivity(intent);
    }
}
