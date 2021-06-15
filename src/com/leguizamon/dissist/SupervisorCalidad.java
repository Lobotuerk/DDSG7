package com.leguizamon.dissist;

import ventanas.VentanaUnirseOP;

public class SupervisorCalidad extends Usuario {

    public SupervisorCalidad() {
        
    }

    
    public SupervisorCalidad(String dni, String apellido, String nombre, String email, String password, String tipoUsuario) {
        super(dni, apellido, nombre, email, password, tipoUsuario);
    }
    
    public void unirseOP() {
        VentanaUnirseOP v = new VentanaUnirseOP();
    }

}
