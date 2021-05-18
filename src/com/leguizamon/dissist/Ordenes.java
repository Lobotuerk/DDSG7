package com.leguizamon.dissist;

import java.util.ArrayList;

public class Ordenes {

    public Ordenes() {

    }

    public void iniciarOP(int numeroOrden, int linea, String modelo, String color, Turno turno, int horaInicio) {

        String fecha = MisFunciones.getFechaActual();
        String dni = Mdi.getSupervisorLinea().getDni();
        OrdenProduccion op = new OrdenProduccion(dni, numeroOrden, linea, modelo, color, turno, fecha, horaInicio, "INICIADO");
        Mdi.guardarOP(op);

    }

    public void pausarOP(OrdenProduccion ordenProduccion) {
        ArrayList<OrdenProduccion> ordenes = Mdi.getArrayOrdenes();
        for (OrdenProduccion o : ordenes) {
            if (o.getNumeroOrden() == ordenProduccion.getNumeroOrden()) {
                o.setEstado("PAUSADO");
            }
        }
        Mdi.actualizarOP(ordenes);

    }

    public void reanudarOP(OrdenProduccion ordenProduccion, String fecha, Turno turno, int hora) {
        ArrayList<OrdenProduccion> ordenes = Mdi.getArrayOrdenes();
        for (OrdenProduccion op : ordenes) {
            if (op.getNumeroOrden() == ordenProduccion.getNumeroOrden()) {
                op.setFecha(fecha);
                op.setTurno(turno);
                op.setHoraInicio(hora);
                op.setEstado("INICIADO");
            }
        }
        Mdi.actualizarOP(ordenes);

    }

    public void finalizarOP(OrdenProduccion ordenProduccion) {
        ArrayList<OrdenProduccion> ordenes = Mdi.getArrayOrdenes();
        for (OrdenProduccion o : ordenes) {
            if (o.getNumeroOrden() == ordenProduccion.getNumeroOrden()) {
                o.setEstado("FINALIZADO");
            }
        }
        Mdi.actualizarOP(ordenes);

    }

    public Boolean tieneOpPendientes() {
        ArrayList<OrdenProduccion> ordenes = Mdi.getArrayOrdenes();
        String dni = Mdi.getSupervisorLinea().getDni();
        for (OrdenProduccion o : ordenes) {
            if (o.getDni().equals(dni)) {
                if (!o.getEstado().equals("FINALIZADO")) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<OrdenProduccion> getArrayOrdenes() {
        return Mdi.getArrayOrdenes();
    }

}
