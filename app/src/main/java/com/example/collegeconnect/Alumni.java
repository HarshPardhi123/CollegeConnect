package com.example.collegeconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Alumni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni);
        getSupportActionBar().setTitle("UDMS Alumni");
    }
}