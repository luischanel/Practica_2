package com.luisdavila.item1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText eExpo, ePrac, eProy, eNota;
    Button bCalc, bLim;
    String p1="15";
    String p2="50";
    String p3="35";
    String n1="";
    String n2="";
    String n3="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eExpo = (EditText) findViewById(R.id.eExpo);
        ePrac = (EditText) findViewById(R.id.ePrac);
        eProy = (EditText) findViewById(R.id.eProy);
        eNota = (EditText) findViewById(R.id.eNotaF);
        bCalc = (Button) findViewById(R.id.bCalcular);
        bLim = (Button) findViewById(R.id.bLimpiar);
        //if(p1<=5.0 && p1>=0 && p2<=5.0 && p2>=0 && p3<=5.0 && p3>=0){
          //  Toast.makeText(this, "Presionó configurar", Toast.LENGTH_SHORT).show();
        //}
        eExpo.setHint(p1);
        ePrac.setHint(p2);
        eProy.setHint(p3);

        bCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nota;
                n1 = eExpo.getText().toString();
                n2 = ePrac.getText().toString();
                n3 = eProy.getText().toString();
                if (n1.length() > 0 && n2.length() > 0 && n3.length() > 0) {
                    if (Double.parseDouble(n1) <= 5.0 && Double.parseDouble(n1) >= 0 &&
                            Double.parseDouble(n2) <= 5.0 && Double.parseDouble(n2) >= 0 &&
                            Double.parseDouble(n3) <= 5.0 && Double.parseDouble(n3) >= 0) {
                        nota = Double.parseDouble(n1) * Double.parseDouble(p1) / 100 +
                                Double.parseDouble(n2) * Double.parseDouble(p2) / 100 +
                                Double.parseDouble(n3) * Double.parseDouble(p3) / 100;
                        eNota.setText( String.format( "%.1f", nota ) );
                    } else {
                        Toast.makeText(MainActivity.this, "Valores en las notas no validos", Toast.LENGTH_SHORT).show();
                    }
                    //Toast.makeText(this, "Presionó configurar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Faltan por ingresar notas", Toast.LENGTH_SHORT).show();
                }


            }
        });
        bLim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nota;
                eExpo.setText("");
                ePrac.setText("");
                eProy.setText("");
                eNota.setText("");

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mConfigurar) {

            Intent intent = new Intent(this, SettingsActivity.class);
           // Toast.makeText(this, "Presionó configurar", Toast.LENGTH_SHORT).show();
            intent.putExtra("pExpo", Integer.parseInt(p1));
            intent.putExtra("pPrac", Integer.parseInt(p2));
            intent.putExtra("pProy",Integer.parseInt(p3));
             //startActivity(intent);
            startActivityForResult(intent, 1234);
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1234 && resultCode == RESULT_OK){
            p1 = data.getExtras().getString("npExp");
            p2 = data.getExtras().getString("npPrac");
            p3 = data.getExtras().getString("npProy");
            eExpo.setHint(p1);
            ePrac.setHint(p2);
            eProy.setHint(p3);

            Toast.makeText(MainActivity.this, "Nuevos Datos: Exposiciones: "+p1+" Practicas"+p2+" " +
                    "Proyecto"+p3,Toast.LENGTH_SHORT).show();
        }
    }
}