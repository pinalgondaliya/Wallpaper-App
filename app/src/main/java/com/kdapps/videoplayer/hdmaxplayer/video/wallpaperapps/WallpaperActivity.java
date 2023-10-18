package com.kdapps.videoplayer.hdmaxplayer.video.wallpaperapps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class WallpaperActivity extends AppCompatActivity {
    ImageView imgwallpaper;
    ImageView homewallpaper, lockwallpaper, bothwallpaper;
    int ssss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        ssss = getIntent().getIntExtra("image", 0);
        imgwallpaper = findViewById(R.id.imgwallpaper);
        homewallpaper = findViewById(R.id.homewallpaper);
        lockwallpaper = findViewById(R.id.lockwallpaper);
        bothwallpaper = findViewById(R.id.bothwallpaper);

        imgwallpaper.setImageResource(ssss);

        homewallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setHomeWallpapers();
            }
        });

        lockwallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLockWallpapers();
            }
        });

        bothwallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setWallpapers();
            }
        });


    }

    private void setWallpapers() {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        try {
            // Decode the image resource or provide the path to your image
            Bitmap wallpaperBitmap = BitmapFactory.decodeResource(getResources(), ssss);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                // On devices running Android Nougat (API 24) and above
                wallpaperManager.setBitmap(wallpaperBitmap, null, true, WallpaperManager.FLAG_LOCK);
                wallpaperManager.setBitmap(wallpaperBitmap, null, true, WallpaperManager.FLAG_SYSTEM);
            } else {
                // On devices running below Android Nougat
                wallpaperManager.setBitmap(wallpaperBitmap);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setLockWallpapers() {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        try {
            Bitmap wallpaperBitmap = BitmapFactory.decodeResource(getResources(), ssss);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                wallpaperManager.setBitmap(wallpaperBitmap, null, true, WallpaperManager.FLAG_LOCK);
            } else {
                wallpaperManager.setBitmap(wallpaperBitmap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setHomeWallpapers() {
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        try {
            Bitmap wallpaperBitmap = BitmapFactory.decodeResource(getResources(), ssss);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                wallpaperManager.setBitmap(wallpaperBitmap, null, true, WallpaperManager.FLAG_SYSTEM);
            } else {
                wallpaperManager.setBitmap(wallpaperBitmap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}