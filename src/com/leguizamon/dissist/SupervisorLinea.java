package com.leguizamon.dissist;

import ventanas.VentanaGestionarOP;

/**
 *
 * @author Luis
 */
public class SupervisorLinea extends Usuario {

    public SupervisorLinea() {
        
    }

    
    public SupervisorLinea(String dni, String apellido, String nombre, String email, String password, String tipoUsuario) {
        super(dni, apellido, nombre, email, password, tipoUsuario);
    }

    public void gestionarOP() {
        VentanaGestionarOP v = new VentanaGestionarOP();
    }
}
