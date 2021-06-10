package com.leguizamon.dissist;

import ventanas.VentanaAdministrador;

public class Administrativo extends Usuario {

    public Administrativo() {
        
    }
    
    public Administrativo(String dni, String apellido, String nombre, String email, String password, String tipoUsuario) {
        super(dni, apellido, nombre, email, password, tipoUsuario);
    }

    public void administrar(){
        VentanaAdministrador v = new VentanaAdministrador();
    }
}
