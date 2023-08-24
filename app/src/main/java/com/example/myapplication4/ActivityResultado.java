package com.example.myapplication4;

import android.content.Intent;
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

        pintarTV(resultadoFibra,fiberColor);
        pintarTV(resultadoBuffer,bufferColor);

        resultadoFibra.setText(colorFiber);
        resultadoBuffer.setText(colorBuffer);

        } else resultadoFibra.setText(message);
    }

    public void pintarTV (TextView tv, String color){

        switch (color){
            case "Azul":
                tv.setBackgroundColor(getColor(R.color.blue));
                tv.setTextColor(getColor(R.color.white));
                break;
            case "Naranja":
                tv.setBackgroundColor(getColor(R.color.orange));
                break;
            case "Verde":
                tv.setBackgroundColor(getColor(R.color.green));
                tv.setTextColor(getColor(R.color.white));
                break;
            case "Café":
                tv.setBackgroundColor(getColor(R.color.brown));
                tv.setTextColor(getColor(R.color.white));
                break;
            case "Gris":
                tv.setBackgroundColor(getColor(R.color.grey));
                break;
            case "Blanco":
                tv.setBackgroundColor(getColor(R.color.white));
                break;
            case "Rojo":
                tv.setBackgroundColor(getColor(R.color.red));
                break;
            case "Negro":
                tv.setBackgroundColor(getColor(R.color.black));
                tv.setTextColor(getColor(R.color.white));
                break;
            case "Amarillo":
                tv.setBackgroundColor(getColor(R.color.yellow));
                break;
            case "Violeta":
                tv.setBackgroundColor(getColor(R.color.violet));
                break;
            case "Rosado":
                tv.setBackgroundColor(getColor(R.color.rose));
                break;
            case "Celeste":
                tv.setBackgroundColor(getColor(R.color.cian));
                break;
        }
    }
}