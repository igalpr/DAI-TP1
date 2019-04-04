package com.example.dai_tp1;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad2 extends Activity {

    private EditText editTextTexto;
    private EditText editTextLetra;
    private Button buttonAccion;
    public void CalcularCantidadLetra(View vista)
    {
        EditText texto;
        texto=findViewById(R.id.TextoIngresado);
        CheckBox checking;
        checking=findViewById(R.id.checkbox);
        if(checking.isChecked()) {
            if(texto.length()>=10)
            {
                String sTexto;
                sTexto=texto.getText().toString();
                int contador;
                contador = 0;
                int i;
                EditText Letra;
                Letra=findViewById(R.id.LetraElegida);
                char LatraElegida=Letra.getText().charAt(0);
                for (i=0;i<sTexto.length();i++)
                {
                    sTexto.toLowerCase();

                    if(sTexto.charAt(i)== LatraElegida)
                    {
                        contador++;
                    }
                }
                TextView textView;
                textView=findViewById(R.id.CantidadIngresada);
                textView.setText("La cantidad de letras "+LatraElegida+" ingresadas es "+contador);
            }


            else
            {
                Toast toast1 =
                        Toast.makeText(getApplicationContext(), "No Tiene el largo de caracteres minimos requeridos", Toast.LENGTH_SHORT);

                toast1.show();
            }
        }
        else {
            String sTexto;
            sTexto=texto.getText().toString();
            int contador;
            contador = 0;
            int i;
            EditText Letra;
            Letra=findViewById(R.id.LetraElegida);
            char LatraElegida=Letra.getText().charAt(0);
            for (i=0;i<sTexto.length();i++)
            {

               if(LatraElegida<90&&LatraElegida>64)

               {
                   sTexto=sTexto.toUpperCase();
               }
               else
               {
                   sTexto=sTexto.toLowerCase();
               }
                if(sTexto.charAt(i)== LatraElegida)
                {
                    contador++;
                }
            }
            TextView textView;
            textView=findViewById(R.id.CantidadIngresada);
            textView.setText("La cantidad de letras "+LatraElegida+" ingresadas es "+contador);


        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        editTextTexto=findViewById(R.id.TextoIngresado);
        editTextLetra=findViewById(R.id.LetraElegida);
        buttonAccion=findViewById(R.id.BotonHacer);

        editTextLetra.addTextChangedListener(ValidarHacer);
        editTextTexto.addTextChangedListener(ValidarHacer);


    }
    private TextWatcher ValidarHacer=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String textoIngresado=editTextTexto.getText().toString().trim();
            String LetraIngredasa=editTextLetra.getText().toString().trim();

            buttonAccion.setEnabled(!textoIngresado.isEmpty()&&!LetraIngredasa.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
