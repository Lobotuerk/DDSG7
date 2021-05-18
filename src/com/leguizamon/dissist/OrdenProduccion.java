package com.leguizamon.dissist;

public class OrdenProduccion {

    private String dni;
    private int numeroOrden;
    private int numeroLinea;
    private String modelo;
    private String color;
    private Turno turno;
    private String fecha;
    private int horaInicio;
    private String estado;

    public OrdenProduccion() {
    }
    
    public OrdenProduccion(String dni, int numeroOrden, int numeroLinea, String modelo, String color, Turno turno, String fecha, int horaInicio, String estado) {
        this.dni = dni;
        this.numeroOrden = numeroOrden;
        this.numeroLinea = numeroLinea;
        this.modelo = modelo;
        this.color = color;
        this.turno = turno;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.estado = estado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
