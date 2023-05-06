package com.example.collegeconnect;

import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class FullscreenImage extends AppCompatActivity {
    ImageView imageView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_image);

        imageView=(ImageView) findViewById(R.id.fullimage);


        Intent intent=getIntent();
        int i=intent.getExtras().getInt("id");
        ImageAdapter imageAdapter=new ImageAdapter(this);
        imageView.setImageResource(imageAdapter.images[i]);


    }
}