package com.example.dm2.ficheros2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    ArrayList<String> a= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.spinner);
        leerREC();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,a);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }
    public void leerREC() {
        try {
            InputStream fraw = getResources().openRawResource(R.raw.recurso);
            BufferedReader brin = new BufferedReader(new InputStreamReader(fraw));
            String linea = brin.readLine();

            while (linea != null) {
                a.add(linea);
                linea = brin.readLine();
            }
            fraw.close();
        } catch (Exception ex) {
            Log.e("Ficheros" , "Error al leer fichero desde recurso raw");
        }

    }

}
