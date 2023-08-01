package com.example.myapplication4;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    int ctaB, ctaI, tamano;
    String mensaje = "";
    public static final String EXTRA_MESSAGE = "com.example.myapplication4.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText campoMensaje = (EditText) findViewById(R.id.tamanoCable);
        campoMensaje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                TextView contador = (TextView) findViewById(R.id.texto_contador);
                String tamanoString = String.valueOf(s.length());
                contador.setText(tamanoString);
            }
        });
    }

    public void resultado(View view) {

        EditText etCtaBuscada = findViewById(R.id.ctaBuscada);
        EditText etCtaInicio = findViewById(R.id.ctaInicio);
        EditText etTamanoCable = findViewById(R.id.tamanoCable);
        if (etCtaInicio.getText().toString().isEmpty() || etCtaBuscada.getText().toString().isEmpty() || etTamanoCable.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Llene todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            try {
                ctaB = Integer.parseInt(etCtaBuscada.getText().toString());
                ctaI = Integer.parseInt(etCtaInicio.getText().toString());
                tamano = Integer.parseInt(etTamanoCable.getText().toString());

                if (tamano == 6 || tamano == 12 || tamano == 24 || tamano == 36 || tamano == 48 || tamano == 72 || tamano == 96 || tamano == 144 || tamano == 288) {

                    int[] fibraBuffer = new int[2];
                    int ctaMax = ctaI + tamano - 1;
                    int aux = ctaB - ctaI + 1;

                    if (ctaB <= ctaMax && ctaB >= ctaI) {

                        if (aux <= 12) {
                            fibraBuffer[0] = aux;
                        } else if (aux % 12 == 0) {
                            fibraBuffer[0] = 12;
                        } else fibraBuffer[0] = aux % 12;

                        int tamanoBuffer;
                        if (tamano >= 48) {
                            tamanoBuffer = 12;
                        } else {
                            tamanoBuffer = 6;
                            if (fibraBuffer[0] > 6) {
                                fibraBuffer[0] -= 6;
                            }
                        }

                        for (int i = 0; i <= tamano / tamanoBuffer; i++) {
                            int max = tamanoBuffer;
                            max *= i;
                            if (aux <= max) {
                                fibraBuffer[1] = i;
                                break;
                            }
                        }

                        if (fibraBuffer[0] == 0 && fibraBuffer[1] == 0) {
                            mensaje = "La fibra " + ctaB + " no se encuentra en este cable.";
                        }

                        String[] colors = new String[2];
                        HashMap<Integer, String> colorsCode = new HashMap<>();
                        colorsCode.put(1, "Azul");
                        colorsCode.put(2, "Naranja");
                        colorsCode.put(3, "Verde");
                        colorsCode.put(4, "Café");
                        colorsCode.put(5, "Gris");
                        colorsCode.put(6, "Blanco");
                        colorsCode.put(7, "Rojo");
                        colorsCode.put(8, "Negro");
                        colorsCode.put(9, "Amarillo");
                        colorsCode.put(10, "Violeta");
                        colorsCode.put(11, "Rosado");
                        colorsCode.put(12, "Celeste");

                        colors[0] = colorsCode.get(fibraBuffer[0]);
                        if (fibraBuffer[1] > 12) {
                            int auxCode = fibraBuffer[1] - 12;
                            String aux2 = colorsCode.get(auxCode);
                            colors[1] = aux2 + " con manchas";
                        } else colors[1] = colorsCode.get(fibraBuffer[1]);
                        mensaje = "La fibra " + ctaB + " es de color: " + colors[0] + ", Se encuentra en el Buffer de color: " + colors[1];

                    } else mensaje = "La fibra " + ctaB + " no se encuentra en este cable.";
                } else mensaje = "No puedo calcular un cable de este tamaño";

                Intent intent = new Intent(this, ActivityResultado.class);
                intent.putExtra(EXTRA_MESSAGE, mensaje);
                startActivity(intent);


            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        }
    }}
