package com.example.collegeconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar1;
    TextView txt,txt2,txt3;
    TextView email,call;
    ImageView imgcourse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        txt2=findViewById(R.id.bamuweb);
        txt2.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://www.bamu.ac.in/dept-of-managementscience/home.aspx'> www.udmsofficial.com </a>";
        txt2.setText(Html.fromHtml(text));

        //for imageslider on dashboard
        ImageSlider imageSlider=findViewById(R.id.image_slider);
        List<SlideModel> slideModels=new ArrayList<SlideModel>();
        slideModels.add(new SlideModel(R.drawable.udmsbanner,"UDMS", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.udmsbannerone,"UDMS", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.ud,"UDMS", ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.udmstwo,"UDMS", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels);

        //for imageslider of faculties on dashboard
        ImageSlider imageSlider1=findViewById(R.id.tells_slider);
        List<SlideModel> slideModelsdemo=new ArrayList<SlideModel>();
        slideModelsdemo.add(new SlideModel(R.drawable.farooquesir_banner,"Prof.Farooque Khan", ScaleTypes.FIT));
        slideModelsdemo.add(new SlideModel(R.drawable.shelkesir_banner,"Prof.Abhijit Shelke", ScaleTypes.FIT));
        slideModelsdemo.add(new SlideModel(R.drawable.waykarsir_banner,"Prof.Yashwant Waykar", ScaleTypes.FIT));
        slideModelsdemo.add(new SlideModel(R.drawable.satishsir_banner,"Prof.Satish Bhalshankar", ScaleTypes.FIT));
        slideModelsdemo.add(new SlideModel(R.drawable.ladmam_banner,"Prof.Kaveri Lad", ScaleTypes.FIT));
        slideModelsdemo.add(new SlideModel(R.drawable.kalanisir_banner,"Prof.Ram Kalani", ScaleTypes.FIT));
        slideModelsdemo.add(new SlideModel(R.drawable.ladmam_banner,"Prof.Sucheta Yambal", ScaleTypes.FIT));
        slideModelsdemo.add(new SlideModel(R.drawable.girisir,"Prof.Dyaneshwar Giri", ScaleTypes.FIT));
        imageSlider1.setImageList(slideModelsdemo);


        //-------------------------------------------------------developer Harsh Pardhi_________

        txt=findViewById(R.id.textroll);
        txt.setSelected(true);
        txt3=findViewById(R.id.txtmarquee);
        txt3.setSelected(true);



        //---------------------------developer harsh Intent Action
        email=findViewById(R.id.emailudms);
        call=findViewById(R.id.calludms);

        //----for calling function
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call_intent=new Intent(Intent.ACTION_DIAL);
                call_intent.setData(Uri.parse("tel: 0240-2403376"));
                startActivity(call_intent);

            }
        });


        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----for email call
                Intent email_intent=new Intent(Intent.ACTION_SEND);
                email_intent.setType("message/rfc822");
                email_intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"head.mgmtsci@bamu.ac.in"});
                email_intent.putExtra(Intent.EXTRA_SUBJECT,"Getting Information About UDMS");
                email_intent.putExtra(Intent.EXTRA_TEXT,"Please Write something ! We are happy to help you");
                startActivity(Intent.createChooser(email_intent,"Mail To Udms Via"));

            }
        });



        //--------------------shared preference to get user data

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("name",MODE_PRIVATE);
        String value=(sharedPreferences.getString("username","name"));




        //--------------------------------------------courses

        imgcourse=findViewById(R.id.bcdept);
        imgcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ibca=new Intent(Dashboard.this,Bcasyllabus.class);
                startActivity(ibca);
            }
        });



        //-----------------------------------------developer Harsh



        toolbar1=findViewById(R.id.toolbar);
        toolbar1.setTitle("Welcome "+value.trim());
        drawerLayout=findViewById(R.id.drwer);
        navigationView=findViewById(R.id.navigation_view);
        setSupportActionBar(toolbar1);

       ActionBarDrawerToggle Toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar1,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(Toggle);
        Toggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.about_udms){

                    Intent i=new Intent(Dashboard.this,Aboutudms.class);
                    startActivity(i);

                }else if(id==R.id.Professors){

                    Intent i=new Intent(Dashboard.this,Faculties.class);
                    startActivity(i);

                }else if(id==R.id.Course){

                    Intent i=new Intent(Dashboard.this,Courses.class);
                    startActivity(i);

                }
                else if(id==R.id.Alumni){

                    Intent i=new Intent(Dashboard.this,Alumni.class);
                    startActivity(i);

                }
                else if(id==R.id.News){

                    Intent i=new Intent(Dashboard.this,News.class);
                    startActivity(i);

                }
                else if(id==R.id.Help){

                    Intent i=new Intent(Dashboard.this,help.class);
                    startActivity(i);

                }else if(id==R.id.Developer){

                    Intent i=new Intent(Dashboard.this,Developer.class);
                    startActivity(i);

                }else if(id==R.id.courses){

                    Intent i=new Intent(Dashboard.this,Courses.class);
                    startActivity(i);

                }else if(id==R.id.result){

                    Intent i=new Intent(Dashboard.this,Result.class);
                    startActivity(i);

                }else if(id==R.id.gallery){

                    Intent i=new Intent(Dashboard.this,Gallery.class);
                    startActivity(i);

                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }


    }
