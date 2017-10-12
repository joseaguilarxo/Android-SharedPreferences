package com.joseaguilar.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtnombre, txtpass,txt1,txt2;
    Button btngo,btnenviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnombre = (EditText) findViewById(R.id.txtnombre);
        txtpass = (EditText) findViewById(R.id.txtpassword);
        txt1 = (EditText) findViewById(R.id.txtuser);
        txt2 = (EditText) findViewById(R.id.txtpass);
        btngo = (Button) findViewById(R.id.btnguardar);
        btnenviar = (Button) findViewById(R.id.btncargar);

        //Para simular un "login" con " guardar datos", creamos un metodo que almacene y guarde esta informacion asi cerremos el app
        cargarPreferencias();

        btngo.setOnClickListener(this);
        btnenviar.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id== R.id.btnguardar){
            GuardarPreferencias();
        }
        if(id ==R.id.btncargar){
            Intent x = new Intent(this, ReceptorPreferences.class);
            startActivity(x);
        }

    }
//---------------------------------------------------------------------
    //CREAMOS SHAREDPREFERENCES
    //Lo recomendable es crear un metodo donde se creara el sharedpreference
    private void GuardarPreferencias() {
        //Instanciamos el sharedpreferences
        SharedPreferences preferencias = getSharedPreferences("Preferencia", Context.MODE_PRIVATE);
        //recogemos los valores que vamos a guardar
        String user = txtnombre.getText().toString();
        String pas = txtpass.getText().toString();
        //Creamos el Editor
        SharedPreferences.Editor editor = preferencias.edit();
        //Almacenamos los valores
        editor.putString("us",user);
        editor.putString("pa",pas);
        //Ahora mostramos la data creada
        txtnombre.setText(user);
        txtpass.setText(pas);
        //Commit
        editor.commit();
    }
//--------------------------------------------------------
    //----CONSUMIENDO SHAREDPREFERENCES
    private void cargarPreferencias() {
        //Instanciamos el sharedpreferences
        SharedPreferences preferencias = getSharedPreferences("Preferencia", Context.MODE_PRIVATE);
        //Ahora consumimos los datos almacenados en el sharedpreferences -- en este ejemplo solo recogemos el nombre de usuario
        String datoU = preferencias.getString("us","No hay data");
        //Mostramos el dato recogido
        txt1.setText(datoU);

    }

}
