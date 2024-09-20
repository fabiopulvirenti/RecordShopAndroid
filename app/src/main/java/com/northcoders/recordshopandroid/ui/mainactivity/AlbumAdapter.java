package com.northcoders.recordshopandroid.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.recordshopandroid.R;
import com.northcoders.recordshopandroid.databinding.AlbumItemBinding;
import com.northcoders.recordshopandroid.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumItemViewHolder> {

    private Context context;
    private List<Album> albumItems;

    public AlbumAdapter(Context context, List<Album> albumItems) {
        this.context = context;
        this.albumItems = albumItems;
    }

    @NonNull
    @Override
    public AlbumItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AlbumItemBinding albumItemBinding = DataBindingUtil.inflate(
               LayoutInflater.from(parent.getContext()),
                R.layout.album_item,
                parent,
                false
        );


        return new AlbumItemViewHolder(albumItemBinding);
    }



    @Override
    public void onBindViewHolder(@NonNull AlbumItemViewHolder holder, int position) {
        Album albumItem = albumItems.get(position);
        holder.albumItemBinding.setAlbum(albumItem);

    }

    @Override
    public int getItemCount() {
        return albumItems.size();
    }

    public static class AlbumItemViewHolder extends RecyclerView.ViewHolder{

       AlbumItemBinding albumItemBinding;
        public AlbumItemViewHolder(AlbumItemBinding albumItemBinding) {
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;
        }


    }

}
