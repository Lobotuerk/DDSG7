package com.leguizamon.dissist;

import java.util.ArrayList;

public class Lineas {

    public ArrayList<Linea> cargarLineas() {
        ArrayList<Linea> arrayLinea = new ArrayList<Linea>();
        Linea linea1 = new Linea(1);
        Linea linea2 = new Linea(2);
        arrayLinea.add(linea1);
        arrayLinea.add(linea2);

        return arrayLinea;
    }

    public ArrayList<Linea> getArrayLineas() {
        return Mdi.getArrayLineas();
    }
}
