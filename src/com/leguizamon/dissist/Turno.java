/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leguizamon.dissist;

import java.util.HashMap;

/**
 *
 * @author Luis
 */
public class Turno {
    private int id;
    private String nombre;
    private int inicio;
    private int fin;
    private int paresSanos;
    private HashMap<String,Integer> paresDefectuoso;

    public int getParesSanos() {
        return paresSanos;
    }

    public void setParesSanos(int paresSanos) {
        this.paresSanos = paresSanos;
    }

    public HashMap<String, Integer> getParesDefectuoso() {
        return paresDefectuoso;
    }

    public void setParesDefectuoso(HashMap<String, Integer> paresDefectuoso) {
        this.paresDefectuoso = paresDefectuoso;
    }

    public Turno() {
    }
    
    public Turno(int id, String nombre, int inicio, int fin) {
        this.id = id;
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.paresSanos = 0;
        this.paresDefectuoso = new HashMap<String, Integer>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
    
    
    
}
