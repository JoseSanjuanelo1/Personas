package com.example.android.personas;

import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Registro extends AppCompatActivity {

    private EditText nomb, apell, edad;
    private CheckBox basket, estudio, internet;
    private Resources res;
    private TextView msj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        res = this.getResources();
        nomb=(EditText)findViewById(R.id.txtNombre);
        apell=(EditText)findViewById(R.id.txtApellido);
        edad=(EditText)findViewById(R.id.txtEdad);
        msj =(TextView)findViewById(R.id.lblmensaje);

        basket=(CheckBox)findViewById(R.id.chkBasketball);
        estudio=(CheckBox) findViewById(R.id.chkEstudiar);
        internet=(CheckBox) findViewById(R.id.chkInternet);
    }

    public void registrar (View v){

        if(validar()){
            String nombre, apellido, aux="";
            int ed;
            nombre = nomb.getText().toString().trim();
            apellido = apell.getText().toString().trim();
            ed = Integer.parseInt(edad.getText().toString().trim());

            if(basket.isChecked()) aux= res.getString(R.string.bk);

            if(estudio.isChecked()) aux = aux+", "+res.getString(R.string.estudiar);

            if (internet.isChecked()) aux = aux+ ", "+res.getString(R.string.internet);


            Persona p = new Persona(nombre, apellido, ed, aux);
            p.guardar();

            //msj.setText(res.getString(R.string.mensaje));
            new AlertDialog.Builder(this).setMessage(res.getString(R.string.mensaje)).show();
            limpiar();
        }

    }

    public void limpiar (){
        nomb.setText("");
        apell.setText("");
        edad.setText("");
        basket.setChecked(true);
        estudio.setChecked(false);
        internet.setChecked(false);
        msj.setText("");
        nomb.requestFocus();
    }

    public boolean validar(){
        if (nomb.getText().toString().isEmpty() ){
            //Toast.makeText(getApplicationContext(), "Digite por favor el nombre" , Toast.LENGTH_SHORT).show();
            nomb.setError(getResources().getString(R.string.error_1));
            return false;
        }

        if (apell.getText().toString().isEmpty()){
            //Toast.makeText(getApplicationContext(), "Digite por favor el apellido" , Toast.LENGTH_SHORT).show();
            apell.setError(getResources().getString(R.string.error_2));
            return false;
        }

        if (edad.getText().toString().isEmpty()){
            //Toast.makeText(getApplicationContext(), "Digite por favor el apellido" , Toast.LENGTH_SHORT).show();
            edad.setError(getResources().getString(R.string.error_3));
            return false;
        }
        return true;
    }
}
