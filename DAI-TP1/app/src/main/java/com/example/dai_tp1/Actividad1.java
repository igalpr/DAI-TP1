package com.example.dai_tp1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

    }
    public void CalcularInformacion(View Vista)
    {
        EditText texto1;
        texto1=findViewById(R.id.Text1);
        EditText texto2;
        texto2=findViewById(R.id.Text2);
        TextView ConsignaA;
        ConsignaA=findViewById(R.id.ConsignaA);

        ConsignaA.setText("El primer texto tiene "+texto1.getText().length()+" caracteres y el segundo texto tiene "+texto2.getText().length());

        TextView ConsignaB;
        ConsignaB=findViewById(R.id.ConsignaB);
        int diferencia;
        if(texto1.getText().length()>texto2.getText().length())
        {

            diferencia=texto1.getText().length()-texto2.getText().length();
        }
        else
        {
            diferencia=-(texto1.getText().length()-texto2.getText().length());
        }
        ConsignaB.setText("La cantidad de caracteres excedentes es "+diferencia);

        TextView ConsignaC;
        ConsignaC=findViewById(R.id.ConsignaC);
        if(3>texto1.getText().length()||3>texto2.getText().length())
        {
            ConsignaC.setText("la cantidad del valor de los caracteres de uno de los textos es menor a tres");
        }
        else
        {
            String PrimerasTres;
            String UltimasTres;
            PrimerasTres=texto1.getText().toString().substring(0,3);
            UltimasTres=texto2.getText().toString().substring(0,3);
            ConsignaC.setText("Prueba xd " + PrimerasTres + UltimasTres);
        }
    }
}
