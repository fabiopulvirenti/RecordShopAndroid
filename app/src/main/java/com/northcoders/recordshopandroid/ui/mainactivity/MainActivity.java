package com.northcoders.recordshopandroid.ui.mainactivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.recordshopandroid.R;
import com.northcoders.recordshopandroid.databinding.ActivityMainBinding;
import com.northcoders.recordshopandroid.model.Album;
import com.northcoders.recordshopandroid.service.AlbumRepository;
import com.northcoders.recordshopandroid.ui.updatealbum.UpdateAlbumActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {


    private RecyclerView recyclerView;
    private List<Album> albumList;
    private AlbumAdapter albumAdapter;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    private MainActivityClickHandler clickHandler;
    private SearchView searchView;
    private ArrayList<Album> filteredAlbumList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        clickHandler = new MainActivityClickHandler(this);
        binding.setClickHandler(clickHandler);


        getAllAlbums();
        searchView =findViewById(R.id.searchView);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {

                filterList(newText);
                return true;
            }
        });

    }

    private void filterList(String newText){

        // new arrayList to hold filtered items
        filteredAlbumList = new ArrayList<>();
        // iterate over the bookList
        for (Album album:albumList){
            if(album.getAlbumName().toLowerCase().contains(newText.toLowerCase())){
                filteredAlbumList.add(album);
            }
        }

        if(filteredAlbumList.isEmpty()){
            Toast.makeText(MainActivity.this,"No albums found", Toast.LENGTH_SHORT).show();
        } else{
            albumAdapter.setFilteredList(filteredAlbumList);
        }



    }



    private void getAllAlbums() {
        viewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumsFromliveData) {


                albumList = (ArrayList<Album>)albumsFromliveData;

                displayAlbumInRecyclerView();

            }
        });

    }

    private void displayAlbumInRecyclerView() {

        recyclerView = binding.albumRecyclerView;
        albumAdapter = new AlbumAdapter(this, albumList,this);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        albumAdapter.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(this, UpdateAlbumActivity.class);
        intent.putExtra(UpdateAlbumActivity.ALBUM_KEY, this.albumList.get(position) );
        this.startActivity(intent);
    }
}







