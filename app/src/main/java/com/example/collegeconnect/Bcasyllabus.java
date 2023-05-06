package com.example.collegeconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Bcasyllabus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcasyllabus);

      PDFView pdfView=findViewById(R.id.pdf);
      pdfView.fromAsset("bcasyllabus.pdf").load();


    }
}