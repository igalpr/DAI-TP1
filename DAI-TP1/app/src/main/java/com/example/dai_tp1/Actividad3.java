package com.example.dai_tp1;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad3 extends Activity {

    private EditText editTextTexto10Caracteres;
    private Button buttonInvertir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);
        editTextTexto10Caracteres=findViewById(R.id.Texto10Caracteres);
        buttonInvertir=findViewById(R.id.BotonInvertir);

        editTextTexto10Caracteres.addTextChangedListener(Requires);
    }
        private TextWatcher Requires=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String TextoIngresado=editTextTexto10Caracteres.getText().toString().trim();

                buttonInvertir.setEnabled(!TextoIngresado.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    public void Invertir(View vista)
    {
        EditText Texto;
        Texto=findViewById(R.id.Texto10Caracteres);
        TextView Invertido;
        Invertido=findViewById(R.id.TextoInvertido);

        if(Texto.getText().length()>=10)
        {
            StringBuilder extra;
            extra=new StringBuilder(Texto.getText().toString()).reverse();
            String Original=Texto.getText().toString();
            String Inver=extra.toString();
            int Comparador=Original.compareTo(Inver);
            if(Comparador==0)
            {
                Invertido.setText(extra + " es el texto invertido y es capicua");
            }
            else
            {
                Invertido.setText(extra);
            }

        }
        else
        {
            Invertido.setText("El texto ingresado debe tener 10 o mas caracteres");
        }

    }

}
