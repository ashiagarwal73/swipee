package com.agarwal.ashi.swipee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
     ViewPager vPagerMain;
    CustomPageAdapter cpa;
 static    double latitude;
  static   double longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPagerMain=(ViewPager)findViewById(R.id.vPagerMain);
        cpa=new CustomPageAdapter(getSupportFragmentManager());
        vPagerMain.setAdapter(cpa);
        Intent intent=new Intent(getApplicationContext(),service.class);
        startService(intent);

     }

     public static class CustomPageAdapter extends FragmentPagerAdapter
     {
        public static  int NUM=3;
         CustomPageAdapter(FragmentManager fragmentManager){
             super(fragmentManager);
         }
         @Override
         public Fragment getItem(int position) {
             switch (position)
             {
                 case 0: return new F_one();
                 case 1: return new F_two();
                 case 2: return new F_three();
                 default:
                     return null;
             }
         }

         @Override
         public int getCount() {
             return NUM;
         }

         @Override
         public CharSequence getPageTitle(int position) {
             switch(position){
                 case 0: return "Police";
                 case 1: return "Railway";
                 case 2: return "Tourism";
                 default: return null;
             }

         }
     }
}
