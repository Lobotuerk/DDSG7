package com.leguizamon.dissist;

public class Hora {
    private int id;
    private int numeroOrden;
    private String fecha;
    private int hora;
    private int objetivo;

    public Hora(int id, int numeroOrden, String fecha, int hora, int objetivo) {
        this.id = id;
        this.numeroOrden = numeroOrden;
        this.fecha = fecha;
        this.hora = hora;
        this.objetivo = objetivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(int objetivo) {
        this.objetivo = objetivo;
    }

}
