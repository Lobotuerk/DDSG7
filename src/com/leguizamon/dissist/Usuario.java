/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leguizamon.dissist;

import ventanas.VentanaLogin;

/**
 *
 * @author Luis
 */
public class Usuario {

    private String dni;
    private String apellido;
    private String nombre;
    private String email;
    private String password;
    private String tipoUsuario;

    public Usuario() {
    }
    
    public Usuario(String dni, String apellido, String nombre, String email, String password, String tipoUsuario) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public void mostrarVentanaLogin() {
        VentanaLogin v = new VentanaLogin();
    }
    
    public Usuario getUsuario(){
        Usuario usuario = new Usuario(dni, apellido, nombre, email, password, tipoUsuario);
        return usuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
