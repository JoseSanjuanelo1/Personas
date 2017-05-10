package com.example.android.personas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by android on 04/04/2017.
 */

public class Datos {

    public static ArrayList<Persona> traerPersonas (Context contexto){
        SQLiteDatabase db;
        String sql, foto, nombre, apellido, pasatiempo;
        int edad;
        ArrayList<Persona> personas = new ArrayList<>();

        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto, "DBPersonas", null,1);
        db = aux.getReadableDatabase();

        //cursor

        sql = "Select foto, nombre, apellido, edad, pasatiempo from Personas";

        Cursor c = db.rawQuery(sql, null);

        if (c.moveToFirst())
            do {
                foto = c.getString(0);
                nombre = c.getString(1);
                apellido = c.getString(2);
                edad = Integer.parseInt(c.getString(3));
                pasatiempo = c.getString(4);

                Persona p = new Persona(foto, nombre, apellido, edad, pasatiempo);
                personas.add(p);
            }while (c.moveToNext());

        db.close();

        return personas;
    }

    public static Persona buscar(Context contexto, String nomb){
        SQLiteDatabase db;
        String sql, foto, nombre, apellido, pasatiempo;
        int edad;
        Persona p=null;

        PersonasSQLiteOpenHelper aux = new PersonasSQLiteOpenHelper(contexto, "DBPersonas", null,1);
        db = aux.getReadableDatabase();

        //cursor

        sql = "Select foto, nombre, apellido, edad, pasatiempo from Personas where nombre='"+nomb+"'";

        Cursor c = db.rawQuery(sql, null);

        if (c.moveToFirst())

                foto = c.getString(0);
                nombre = c.getString(1);
                apellido = c.getString(2);
                edad = Integer.parseInt(c.getString(3));
                pasatiempo = c.getString(4);

                p = new Persona( nombre, apellido, edad, pasatiempo);

        db.close();

        return p;
    }
}
