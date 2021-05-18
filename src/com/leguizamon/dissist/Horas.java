package com.leguizamon.dissist;

import java.util.ArrayList;

public class Horas {

    public void agregarHora(Hora hora) {
        Mdi.addHora(hora);
    }

    public void actualizarHoras(ArrayList<Hora> arrayHoras) {
        Mdi.actualizarHoras(arrayHoras);
    }

    public ArrayList<Hora> getArrayHoras() {
        return Mdi.getArrayHoras();
    }
}
