package com.northcoders.recordshopandroid.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
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
    private RecyclerViewInterface recyclerViewInterface;

    public AlbumAdapter(Context context, List<Album> albumItems,RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.albumItems = albumItems;
        this.recyclerViewInterface=recyclerViewInterface;
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


        return new AlbumItemViewHolder(albumItemBinding, recyclerViewInterface);
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
        public AlbumItemViewHolder(AlbumItemBinding albumItemBinding, RecyclerViewInterface recyclerViewInterface) {
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int position = getAdapterPosition();

                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }


    }

}
