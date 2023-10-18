package com.kdapps.videoplayer.hdmaxplayer.video.wallpaperapps.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kdapps.videoplayer.hdmaxplayer.video.wallpaperapps.Model.WallpaperModel;
import com.kdapps.videoplayer.hdmaxplayer.video.wallpaperapps.R;
import com.kdapps.videoplayer.hdmaxplayer.video.wallpaperapps.WallpaperActivity;

import java.util.ArrayList;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.wallpaperViewHolder> {
    ArrayList<WallpaperModel> arrayList;
    Context context;

    public WallpaperAdapter(ArrayList<WallpaperModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public wallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wallpaper,parent,false);
        return new wallpaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull wallpaperViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageMAin.setImageResource(arrayList.get(position).getWallpaperImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WallpaperActivity.class);
                intent.putExtra("image",arrayList.get(position).getWallpaperImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class wallpaperViewHolder extends RecyclerView.ViewHolder{
        ImageView imageMAin;

        public wallpaperViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMAin = itemView.findViewById(R.id.imageMAin);
        }
    }
}
