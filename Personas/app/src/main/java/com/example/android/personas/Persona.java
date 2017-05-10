package com.example.android.personas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by android on 04/04/2017.
 */

public class Persona {
    private String foto;
    private String nombre;
    private String apellido;
    private int edad;
    private String pasatiempo;

    public Persona(String nombre, String apellido, int edad, String pasatiempo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pasatiempo = pasatiempo;
    }

    public Persona(String foto, String nombre, String apellido, int edad, String pasatiempo) {
        this.foto = foto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pasatiempo = pasatiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPasatiempo() {
        return pasatiempo;
    }

    public void setPasatiempo(String pasatiempo) {
        this.pasatiempo = pasatiempo;
    }

    public String getFoto() { return foto; }

    public void setFoto(String foto) { this.foto = foto; }

    public void guardar(Context contexto){
        SQLiteDatabase db;
        String sql;

        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto, "DBPersonas", null, 1);
        db = aux.getWritableDatabase();

        //FORMA 1

        sql = "INSERT INTO Personas values('"+this.getFoto()+"','"+this.getNombre()+"','"+this.getApellido()+"','"+this.getEdad()+"','"+this.getPasatiempo()+"')";
        db.execSQL(sql);

        //FORMA 2

        //Datos.guardar(this);
    }

    public void modificar(Context contexto){
        SQLiteDatabase db;
        String sql;

        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto, "DBPersonas", null, 1);
        db = aux.getWritableDatabase();

        //FORMA 1

        sql = "UPDATE Personas set apellido='"+this.getApellido()+"',edad='"+this.getEdad()+"', pasatiempo='"+this.getPasatiempo()+"'where nombre like '%"+this.getNombre()+"%'";
        db.execSQL(sql);
    }
}
