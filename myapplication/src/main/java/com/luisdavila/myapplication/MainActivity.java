package com.luisdavila.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bBar = (Button) findViewById(R.id.bBares);


    }




    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mAcerca) {

            Intent intent = new Intent(this, Acerca.class);
//
            startActivityForResult(intent, 1234);
        }
        return super.onOptionsItemSelected(item);
    }

    public void mostrarBares(View view){
        Intent intent = new Intent(this, BaresActivity.class);
//
        startActivityForResult(intent, 1234);
        // Hace algo cuando pulsemos el botón
    }
    public void bmostrarSitios(View view){
        Intent intent = new Intent(this, TurismoActivity.class);
//
        startActivityForResult(intent, 1234);
        // Hace algo cuando pulsemos el botón
    }
    public void mostrarHoteles(View view){
        Intent intent = new Intent(this, HotelesActivity.class);

        startActivityForResult(intent, 1234);
    }
    public void mostrarDemg(View view){
        Intent intent = new Intent(this, DemografiaActivity.class);

        startActivityForResult(intent, 1234);
    }
}