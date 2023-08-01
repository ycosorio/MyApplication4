package com.example.myapplication4;


import android.content.Intent;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView resultadoFibra = findViewById(R.id.tvResultadoFibra);
        TextView resultadoBuffer = findViewById(R.id.tvResultadoBuffer);

        if(message.contains(",")){
        String colorFiber = message.substring(0,message.indexOf(","));
        String colorBuffer = message.substring(message.indexOf(",")+2);

        String fiberColor = colorFiber.substring(colorFiber.indexOf(":")+2);
        String bufferColor = colorBuffer.substring(colorBuffer.indexOf(":")+2);
        if(bufferColor.contains("con")){
            bufferColor = bufferColor.substring(0,bufferColor.indexOf(" "));
        }

        switch (fiberColor){
            case "Azul":
                resultadoFibra.setBackgroundColor(getColor(R.color.blue));
                resultadoFibra.setTextColor(getColor(R.color.white));
                break;
            case "Naranja":
                resultadoFibra.setBackgroundColor(getColor(R.color.orange));
                break;
            case "Verde":
                resultadoFibra.setBackgroundColor(getColor(R.color.green));
                resultadoFibra.setTextColor(getColor(R.color.white));
                break;
            case "Café":
                resultadoFibra.setBackgroundColor(getColor(R.color.brown));
                resultadoFibra.setTextColor(getColor(R.color.white));
                break;
            case "Gris":
                resultadoFibra.setBackgroundColor(getColor(R.color.grey));
                break;
            case "Blanco":
                resultadoFibra.setBackgroundColor(getColor(R.color.white));
                break;
            case "Rojo":
                resultadoFibra.setBackgroundColor(getColor(R.color.red));
                break;
            case "Negro":
                resultadoFibra.setBackgroundColor(getColor(R.color.black));
                resultadoFibra.setTextColor(getColor(R.color.white));
                break;
            case "Amarillo":
                resultadoFibra.setBackgroundColor(getColor(R.color.yellow));
                break;
            case "Violeta":
                resultadoFibra.setBackgroundColor(getColor(R.color.violet));
                break;
            case "Rosado":
                resultadoFibra.setBackgroundColor(getColor(R.color.rose));
                break;
            case "Celeste":
                resultadoFibra.setBackgroundColor(getColor(R.color.cian));
                break;
        }
        switch (bufferColor){
            case "Azul":
                resultadoBuffer.setBackgroundColor(getColor(R.color.blue));
                resultadoBuffer.setTextColor(getColor(R.color.white));
                break;
            case "Naranja":
                resultadoBuffer.setBackgroundColor(getColor(R.color.orange));
                break;
            case "Verde":
                resultadoBuffer.setBackgroundColor(getColor(R.color.green));
                resultadoBuffer.setTextColor(getColor(R.color.white));
                break;
            case "Café":
                resultadoBuffer.setBackgroundColor(getColor(R.color.brown));
                resultadoBuffer.setTextColor(getColor(R.color.white));
                break;
            case "Gris":
                resultadoBuffer.setBackgroundColor(getColor(R.color.grey));
                break;
            case "Blanco":
                resultadoBuffer.setBackgroundColor(getColor(R.color.white));
                break;
            case "Rojo":
                resultadoBuffer.setBackgroundColor(getColor(R.color.red));
                break;
            case "Negro":
                resultadoBuffer.setBackgroundColor(getColor(R.color.black));
                resultadoBuffer.setTextColor(getColor(R.color.white));
                break;
            case "Amarillo":
                resultadoBuffer.setBackgroundColor(getColor(R.color.yellow));
                break;
            case "Violeta":
                resultadoBuffer.setBackgroundColor(getColor(R.color.violet));
                break;
            case "Rosado":
                resultadoBuffer.setBackgroundColor(getColor(R.color.rose));
                break;
            case "Celeste":
                resultadoBuffer.setBackgroundColor(getColor(R.color.cian));
                break;
        }


        resultadoFibra.setText(colorFiber);
        resultadoBuffer.setText(colorBuffer);

        } else resultadoFibra.setText(message);
    }
}