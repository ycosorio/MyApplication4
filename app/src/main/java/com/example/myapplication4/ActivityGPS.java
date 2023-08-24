package com.example.myapplication4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ActivityGPS extends AppCompatActivity {

    ArrayList<Nodos> nodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        crearListado();



    }
    public void crearListado(){
        nodos = new ArrayList<>();
        InputStream archivo = getResources().openRawResource(R.raw.prueba);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(archivo));
        boolean seguir = true;

        while (seguir){
            try {
                String linea = buffer.readLine();
                String[] texto = linea.split(":");
                Nodos nodo = new Nodos(texto[0],texto[1],texto[2],Double.parseDouble(texto[3]),Double.parseDouble(texto[4]));
                nodos.add(nodo);

            } catch (Exception e){
                seguir=false;
            }
        }
    }

    public void buscarNodo(View view){

        EditText nodoBuscado = findViewById(R.id.nodoBuscado);
        TextView nodoResultado = findViewById(R.id.tvResultadoNodo);
        String nBuscado = nodoBuscado.getText().toString();

        int aux = 0;
        for (Nodos nodo: nodos) {
            if(nodo.getNombre().equalsIgnoreCase(nBuscado)){
                aux++;
            }
        }
            if (aux ==0)
            {Toast.makeText(getApplicationContext(), "Nodo no encontrado, intente otro nombre", Toast.LENGTH_SHORT).show();
            nodoBuscado.setText("");}


        for (Nodos nodo: nodos) {
            if(nodo.getNombre().equalsIgnoreCase(nBuscado)){
                String link = nodo.getNombre()+": "+nodo.getDireccion()+", "+nodo.getComuna();
                nodoResultado.setText(link);
                nodoResultado.setVisibility(View.VISIBLE);

                Button button = findViewById(R.id.btnIr);
                button.setVisibility(View.VISIBLE);


                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Uri gmmIntentUri = Uri.parse("geo:0,0?q="+nodo.getLatitud()+","+nodo.getLongitud()+"("+nodo.getNombre()+": "+nodo.getDireccion()+", "+nodo.getComuna()+")");

                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                    }
                });


            }





        }
    }



}
