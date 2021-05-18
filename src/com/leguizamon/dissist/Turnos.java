package com.leguizamon.dissist;

import java.util.ArrayList;

public class Turnos {

    public ArrayList<Turno> getArrayTurnos() {
        return Mdi.getArrayTurnos();
    }

    public ArrayList<Turno> cargarTurnos() {
        ArrayList<Turno> turno = new ArrayList<Turno>();
        Turno turno1 = new Turno(1, "Mañana", 6, 14);
        Turno turno2 = new Turno(2, "Tarde", 14, 22);
        Turno turno3 = new Turno(3, "Noche",22,6);

        turno.add(turno1);
        turno.add(turno2);
        turno.add(turno3);
        return turno;
    }

    /**
     * Busca y devuelve un turno por su nombre
     * @param nombre
     * @return 
     */
    public Turno getTurnoByNombre(String nombre) {
        Turno turnoEncontrado = new Turno();
        for (Turno t : getArrayTurnos()) {
            if (t.getNombre().equals(nombre)) {
                turnoEncontrado = t;
            }
        }
        return turnoEncontrado;
    }
}
