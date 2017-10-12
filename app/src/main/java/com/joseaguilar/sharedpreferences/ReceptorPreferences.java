package com.joseaguilar.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ReceptorPreferences extends AppCompatActivity {
    EditText txtu, txtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptor_preferences);

        txtu=(EditText)findViewById(R.id.txtnombre2);
        txtp=(EditText)findViewById(R.id.txtpassword2);

        cargarPreferencias();
    }

    //----CONSUMIENDO SHAREDPREFERENCES
    private void cargarPreferencias() {
        //Instanciamos el sharedpreferences
        SharedPreferences preferencias = getSharedPreferences("Preferencia", Context.MODE_PRIVATE);
        //Ahora consumimos los datos almacenados en el sharedpreferences --
        String datoU = preferencias.getString("us","No hay data");
        String datoP = preferencias.getString("pa","No hay data");
        //Mostramos el dato recogido
        txtu.setText(datoU);
        txtp.setText(datoP);

    }


}
