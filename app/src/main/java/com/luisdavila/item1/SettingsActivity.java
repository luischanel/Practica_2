package com.luisdavila.item1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    EditText epExpo, epPrac,epProy;
    Button bGuardar, bbLim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        epExpo = (EditText) findViewById(R.id.epExpo);
        epPrac = (EditText) findViewById(R.id.epPrac);
        epProy = (EditText) findViewById(R.id.epProy);
        bGuardar = (Button) findViewById(R.id.bGuardar);
        bbLim = (Button) findViewById(R.id.bbLimpiar);
        Bundle extras = getIntent().getExtras();

        epExpo.setText(String.valueOf(extras.getInt("pExpo")));
        epPrac.setText(String.valueOf(extras.getInt("pPrac")));
        epProy.setText(String.valueOf(extras.getInt("pProy")));

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String p1 = epExpo.getText().toString();
                String p2 = epPrac.getText().toString();
                String p3 = epProy.getText().toString();
                Intent intent = new Intent();
                if (p1.length() > 0 && p2.length() > 0 && p3.length() > 0) {
                    if (Double.parseDouble(p1) + Double.parseDouble(p2) + Double.parseDouble(p3) == 100 &&
                            Double.parseDouble(p1) > 0 && Double.parseDouble(p2) > 0 && Double.parseDouble(p3) > 0) {
                        intent.putExtra("npExp", p1);
                        intent.putExtra("npPrac", p2);
                        intent.putExtra("npProy", p3);
                        setResult(RESULT_OK, intent);
                        finish();
                    } else {
                        Toast.makeText(SettingsActivity.this, "Porcentajes invalidos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SettingsActivity.this, "Falta un porcentaje por ingresar", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bbLim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nota;
                epExpo.setText("");
                epPrac.setText("");
                epProy.setText("");


            }
        });

    }
}
