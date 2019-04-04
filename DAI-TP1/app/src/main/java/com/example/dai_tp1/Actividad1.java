package com.example.dai_tp1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad1 extends Activity {

    private SeekBar seek;
    private TextView texto;
    private EditText TextoA;
    private EditText TextoB;
    private Button buttonConsignas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
        TextoA=findViewById(R.id.Text1);
        TextoB=findViewById(R.id.Text2);
        buttonConsignas=findViewById(R.id.ComprobarConsignas);

        TextoA.addTextChangedListener(Required);
        TextoB.addTextChangedListener(Required);


        seek=findViewById(R.id.SeekBar);
        texto=findViewById(R.id.TextoBarra);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                texto.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    private TextWatcher Required=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String TextoUno=TextoA.getText().toString().trim();
            String TextoDos=TextoB.getText().toString().trim();

            buttonConsignas.setEnabled(!TextoUno.isEmpty()&&!TextoDos.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
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
        int cantidad;
        cantidad=seek.getProgress();
        if(cantidad>texto1.getText().length()||cantidad>texto2.getText().length())
        {
            ConsignaC.setText("la cantidad del valor de los caracteres de uno de los textos es menor a la elegida por el usuario");
        }
        else
        {

            String PrimerasTres;
            String UltimasTres;
            PrimerasTres=texto1.getText().toString().substring(0,cantidad);
            UltimasTres=texto2.getText().toString().substring(0,cantidad);
            ConsignaC.setText( PrimerasTres + UltimasTres);
        }
    }
}
