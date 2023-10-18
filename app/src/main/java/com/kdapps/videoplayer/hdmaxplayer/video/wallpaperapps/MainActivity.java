package com.kdapps.videoplayer.hdmaxplayer.video.wallpaperapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.kdapps.videoplayer.hdmaxplayer.video.wallpaperapps.Model.WallpaperModel;
import com.kdapps.videoplayer.hdmaxplayer.video.wallpaperapps.adapter.WallpaperAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recwallpaper;
    WallpaperAdapter wallpaperAdapter;
    ArrayList<WallpaperModel> wallpaperModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recwallpaper = findViewById(R.id.recwallpaper);
        wallpaperModelArrayList.add(new WallpaperModel(R.drawable.download_1));
        wallpaperModelArrayList.add(new WallpaperModel(R.drawable.download_2));
        wallpaperModelArrayList.add(new WallpaperModel(R.drawable.download_3));
        wallpaperModelArrayList.add(new WallpaperModel(R.drawable.download_4));
        wallpaperModelArrayList.add(new WallpaperModel(R.drawable.download_5));
        wallpaperModelArrayList.add(new WallpaperModel(R.drawable.download_6));
        wallpaperAdapter = new WallpaperAdapter(wallpaperModelArrayList,this);
        recwallpaper.setAdapter(wallpaperAdapter);

    }
}