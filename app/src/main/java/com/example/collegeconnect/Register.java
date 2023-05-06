package com.example.collegeconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Register extends AppCompatActivity {
 FirebaseDatabase firebaseDatabase;
 DatabaseReference databaseReference;
 EditText txt1,txt2,txt3,txt4,txt5;
 Studentinfo obj;
 Button btn;
 ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       

        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        txt1=findViewById(R.id.username);
        txt2=findViewById(R.id.useremail);
        txt3=findViewById(R.id.usermobile);
        txt4=findViewById(R.id.Course);
        txt5=findViewById(R.id.city);
      firebaseDatabase = FirebaseDatabase.getInstance();
       databaseReference = firebaseDatabase.getReference("Students");
        obj=new Studentinfo();
        btn=findViewById(R.id.dbstore);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=txt1.getText().toString();
                String email=txt2.getText().toString();
                String mobile=txt3.getText().toString();
                String course=txt4.getText().toString();
                String city=txt5.getText().toString();

                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("name",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username",name);
                editor.apply();


                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(Register.this, "Please Enter Your name.", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(email)) {
                    Toast.makeText(Register.this, "Please Enter Your Email", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(mobile)){
                    Toast.makeText(Register.this, "Please Enter Your Mobile.", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(course)){
                    Toast.makeText(Register.this, "Please Enter Your Course.", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(city)){
                    Toast.makeText(Register.this, "Please Enter Your City.", Toast.LENGTH_SHORT).show();
                }
                else{
                    progressBar.setVisibility(View.VISIBLE);
                    obj.setStudentname(name);
                    obj.setEmailstudent(email);
                    obj.setMobile(mobile);
                    obj.setCourse(course);
                    obj.setCity(city);
                    firebaseDatabase=FirebaseDatabase.getInstance();
                    databaseReference=firebaseDatabase.getReference("UdmsData");
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.child(name).setValue(obj);
                            progressBar.setVisibility(View.INVISIBLE);

                            Toast.makeText(Register.this, "Succesfully Registered", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(Register.this,Dashboard.class);
                            startActivity(i);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(Register.this, "Something Wrong Encountered", Toast.LENGTH_SHORT).show();
                        }
                    });

                }


            }


        });



    }


   }



