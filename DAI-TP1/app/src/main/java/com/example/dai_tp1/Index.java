package com.example.dai_tp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Index extends Activity {

    public void Llevaraotrapantalla1(View vista)
    {
        Intent LLamarPrimera;
        LLamarPrimera=new Intent(this,Actividad1.class);
        startActivity(LLamarPrimera);
    }
    public void Llevaraotrapantalla2(View vista)
    {
        Intent LlamarSegunda;
        LlamarSegunda=new Intent(this,Actividad2.class);
        startActivity(LlamarSegunda);
    }
    public void Llevaraotrapantalla3(View vista)
    {
        Intent LLamarTercera;
        LLamarTercera=new Intent(this,Actividad3.class);
        startActivity(LLamarTercera);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
    }
}
