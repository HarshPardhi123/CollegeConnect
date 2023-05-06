package com.example.collegeconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Courses extends AppCompatActivity {
    ImageView img;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);


        img=findViewById(R.id.bcacourse);
        txt=findViewById(R.id.bca1);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ipdf=new Intent(Courses.this,Bcasyllabus.class);
                startActivity(ipdf);

            }
        });
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ipdf=new Intent(Courses.this,Bcasyllabus.class);
                startActivity(ipdf);

            }
        });




    }
}