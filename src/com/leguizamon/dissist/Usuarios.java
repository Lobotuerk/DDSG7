package com.leguizamon.dissist;

import java.util.ArrayList;

public class Usuarios {

    /**
     * Constructor vacío
     */
    public Usuarios() {
    }

    public ArrayList<Usuario> cargarUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario supervisorLinea = new Usuario("123", "Perez", "Juan", "superlinea@gmail.com", "123", "supervisorLinea");
        usuarios.add(supervisorLinea);
        return usuarios;
    }
    
    /**
     * Si los datos recibidos corresponden a un usuario se carga el usuario
     *
     * @param dni
     * @param password
     * @param usuarios
     * @return
     */
    public Boolean esSupervisorLinea(String dni, String password, ArrayList<Usuario> usuarios) {
        Boolean resultado = false;
        for (Usuario usuario : usuarios) {
            if (dni.equals(usuario.getDni()) && password.equals(usuario.getPassword())) {
                if (usuario.getTipoUsuario().equals("supervisorLinea")) {
                    resultado = true;                    
                    break;
                }
            }
        }
        return resultado;
    }
    
    public void cargarSupervisorLinea(String dni, String password, ArrayList<Usuario> usuarios){
        for (Usuario usuario : usuarios) {
            if (dni.equals(usuario.getDni()) && password.equals(usuario.getPassword())) {
                if (usuario.getTipoUsuario().equals("supervisorLinea")) {
                    SupervisorLinea sl = new SupervisorLinea();
                    sl.setDni(usuario.getDni());
                    sl.setApellido(usuario.getApellido());
                    sl.setNombre(usuario.getNombre());
                    sl.setEmail(usuario.getEmail());
                    sl.setPassword(usuario.getPassword());
                    sl.setTipoUsuario(usuario.getTipoUsuario());
                    Mdi.cargarSupervisorLinea(sl);
                    break;
                }
            }
        }
    }

    /**
     * Devuelve todos los usuarios
     *
     * @return
     */
    public ArrayList<Usuario> getArrayUsuarios() {
        return Mdi.getArrayUsuarios();
    }
}
