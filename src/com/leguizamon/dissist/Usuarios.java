package com.leguizamon.dissist;

import java.util.ArrayList;

public class Usuarios {

    /**
     * Constructor vacío
     */
    public Usuarios() {
    }

    public ArrayList<Usuario> cargarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario supervisorLinea = new Usuario("123", "Perez", "Juan", "superlinea@gmail.com", "123", "supervisorLinea");
        Usuario supervisorCalidad = new Usuario("456", "Sanchez", "Hugo", "supercalidad@gmail", "456", "supervisorCalidad");
        Usuario administrativo = new Usuario("789", "Gonzalez", "Mario", "administrativo@gmail.com", "789", "administrativo");
        usuarios.add(supervisorLinea);
        usuarios.add(supervisorCalidad);
        usuarios.add(administrativo);
        return usuarios;
    }

    public String obtenerTipoUsuario(String dni, String password, ArrayList<Usuario> usuarios) {
        String tipo = "";
        for (Usuario usuario : usuarios) {
            if (dni.equals(usuario.getDni()) && password.equals(usuario.getPassword())) {
                tipo = usuario.getTipoUsuario();
            }
        }
        return tipo;
    }

    public Boolean esUsuario(String dni, String password, ArrayList<Usuario> usuarios) {
        Boolean resultado = false;
        for (Usuario usuario : usuarios) {
            if (dni.equals(usuario.getDni()) && password.equals(usuario.getPassword())) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public void cargarUsuario(String dni, String password, ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (dni.equals(usuario.getDni()) && password.equals(usuario.getPassword())) {
                switch (usuario.getTipoUsuario()) {
                    case "supervisorLinea":
                        SupervisorLinea sl = new SupervisorLinea(usuario.getDni(), usuario.getApellido(), usuario.getNombre(),
                                usuario.getEmail(), usuario.getPassword(), usuario.getTipoUsuario());
                        Mdi.cargarSupervisorLinea(sl);
                        break;
                    case "supervisorCalidad":
                        SupervisorCalidad sc = new SupervisorCalidad(usuario.getDni(), usuario.getApellido(), usuario.getNombre(),
                                usuario.getEmail(), usuario.getPassword(), usuario.getTipoUsuario());
                        Mdi.cargarSupervisorCalidad(sc);
                        break;
                    case "administrativo":
                        Administrativo ad = new Administrativo(usuario.getDni(), usuario.getApellido(), usuario.getNombre(),
                                usuario.getEmail(), usuario.getPassword(), usuario.getTipoUsuario());
                        Mdi.cargarAdministrativo(ad);
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

    public void agregarUsuario(Usuario usuario) {
        ArrayList<Usuario> arrayUsuarios = Mdi.getArrayUsuarios();
        arrayUsuarios.add(usuario);
        Mdi.actualizarArrayUsuarios(arrayUsuarios);
    }

    public void actualizarUsuario(Usuario usuario) {
        ArrayList<Usuario> arrayUsuarios = Mdi.getArrayUsuarios();
        ArrayList<Usuario> nuevoArray = new ArrayList<>();
        for (Usuario u : arrayUsuarios) {
            if (u.getDni().equals(usuario.getDni())) {
                nuevoArray.add(usuario);
            } else {
                nuevoArray.add(u);
            }
        }
        Mdi.actualizarArrayUsuarios(nuevoArray);
    }

    public void eliminarUsuario(String dni) {
        ArrayList<Usuario> arrayUsuarios = Mdi.getArrayUsuarios();
        ArrayList<Usuario> nuevoArray = new ArrayList<>();
        for (Usuario u : arrayUsuarios) {
            if (!u.getDni().equals(dni)) {
                nuevoArray.add(u);
            }
        }
        Mdi.actualizarArrayUsuarios(nuevoArray);
    }
}
