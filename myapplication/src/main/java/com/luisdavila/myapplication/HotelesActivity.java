package com.luisdavila.myapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class HotelesActivity extends AppCompatActivity {
    ViewPager viewPager;
    CustomHoteles adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagerview);
        viewPager= (ViewPager)findViewById(R.id.view_pager);
        adapter = new CustomHoteles(this);
        viewPager.setAdapter(adapter);
    }
}

