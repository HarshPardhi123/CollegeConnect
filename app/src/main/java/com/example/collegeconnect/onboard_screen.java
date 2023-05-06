package com.example.collegeconnect;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class onboard_screen extends AppCompatActivity {
    ViewPager viewPager;
    ViewpagerAdapter viewpagerAdapter;
    Button btn1;
    DotsIndicator dotsIndicator;







    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (restorePrefData()) {

            Intent mainActivity = new Intent(getApplicationContext(),Register.class );
            startActivity(mainActivity);
            finish();


        }
                setContentView(R.layout.activity_onboard_screen);




        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        viewpagerAdapter = new ViewpagerAdapter(this);
        viewPager.setAdapter(viewpagerAdapter);
        viewPager.addOnPageChangeListener(viewListener);

        //-------------------------Dots
        dotsIndicator=findViewById(R.id.dots_indicator);
        dotsIndicator.setViewPager(viewPager);




            btn1=findViewById(R.id.button2);
            btn1.setVisibility(View.INVISIBLE);
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(onboard_screen.this, Register.class);
                    startActivity(i);
                    savePrefsData();
                    finish();

                }
            });

        }

        @RequiresApi(api = Build.VERSION_CODES.M)


            ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onPageSelected(int position) {

                    if (position==0){

                        btn1.setVisibility(View.INVISIBLE);

                    }else if(position==1) {

                        btn1.setVisibility(View.INVISIBLE);

                    }else{
                        btn1.setVisibility(View.VISIBLE);
                    }


                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }

            };

        private int getitem ( int i){
            return viewPager.getCurrentItem() + i;
        }

    private boolean restorePrefData() {


        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend",false);
        return  isIntroActivityOpnendBefore;



    }

    private void savePrefsData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend",true);
        editor.commit();


    }

    }






