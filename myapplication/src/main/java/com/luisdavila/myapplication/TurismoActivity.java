package com.luisdavila.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Usuario on 03/04/2016.
 */
public class TurismoActivity extends Activity {
    ViewPager viewPager;
    CustomTurismoActivity adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagerview);
        viewPager= (ViewPager)findViewById(R.id.view_pager);
        adapter = new CustomTurismoActivity(this);
        viewPager.setAdapter(adapter);


    }
}

