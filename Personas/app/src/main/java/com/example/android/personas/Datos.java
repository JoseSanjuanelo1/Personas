package com.example.android.personas;

import java.util.ArrayList;

/**
 * Created by android on 04/04/2017.
 */

public class Datos {
    static ArrayList<Persona> personas = new ArrayList<>();

    public static void guardar(Persona p){
        personas.add(p);
    }

    public static ArrayList<Persona> getPersonas() {
        return personas;
    }
}
