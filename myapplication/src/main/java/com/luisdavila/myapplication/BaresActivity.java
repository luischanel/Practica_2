package com.luisdavila.myapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Usuario on 03/04/2016.
 */
public class BaresActivity extends AppCompatActivity {
    ViewPager viewPager;
    CustomBares adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagerview);
        viewPager= (ViewPager)findViewById(R.id.view_pager);
        adapter = new CustomBares(this);
        viewPager.setAdapter(adapter);
    }
}

