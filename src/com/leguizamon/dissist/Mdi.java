package com.leguizamon.dissist;

import ventanas.VentanaGestionarModelo;
import ventanas.VentanaLogin;
import java.util.ArrayList;
import javax.swing.JInternalFrame;

public class Mdi extends javax.swing.JFrame {

    public static VentanaLogin login;
    public static ArrayList<Linea> arrayLineas = new ArrayList<>();
    public static ArrayList<Usuario> arrayUsuarios = new ArrayList<>();
    public static String supervisorLinea;
    public static ArrayList<OrdenProduccion> arrayOrdenes = new ArrayList<>();
    public static Usuarios usuarios = new Usuarios();
    public static SupervisorLinea userSuperLinea = new SupervisorLinea();
    public static SupervisorCalidad userSuperCalidad = new SupervisorCalidad();
    public static Administrativo userAdministrativo = new Administrativo();
    public static Lineas lineas = new Lineas();
    public static Modelos modelos = new Modelos();
    public static ArrayList<Modelo> arrayModelos = new ArrayList<>();
    public static Colores colores = new Colores();
    public static ArrayList<Color> arrayColores = new ArrayList<>();
    public static ArrayList<Hora> arrayHoras = new ArrayList<>();
    public static Turnos turnos = new Turnos();
    public static ArrayList<Turno> arrayTurnos = new ArrayList<>();

    /**
     * Creates new form Mdi
     */
    public Mdi() {
        setVisible(true);
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        cargarDatos();
        userSuperLinea.mostrarVentanaLogin();
    }

    /**
     * Cargamos los datos que vamos a utilizar
     */
    private void cargarDatos() {
        // Cargamos los datos que vamos a necesitar
        arrayModelos = modelos.cargarModelosPredeterminados();
        arrayColores = colores.cargarColoresPredeterminados();
        arrayUsuarios = usuarios.cargarUsuarios();
        arrayTurnos = turnos.cargarTurnos();
        arrayLineas = lineas.cargarLineas();
    }

    // VENTANA
    /**
     * Agregar el JInternalFrame al DesktopJPane "escritorio"
     *
     * @param ventana
     */
    public static void addVentana(JInternalFrame ventana) {
        escritorio.add(ventana);
    }

    // USUARIOS
    /**
     * Recibe el usuario logueado y lo guarda en la variable
     *
     * @param usuarioLogueado
     */
    public static void cargarSupervisorLinea(SupervisorLinea usuarioLogueado) {
        userSuperLinea = usuarioLogueado;
    }

    public static SupervisorLinea getSupervisorLinea() {
        return userSuperLinea;
    }

    public static void cargarSupervisorCalidad(SupervisorCalidad usuarioLogueado) {
        userSuperCalidad = usuarioLogueado;
    }

    public static SupervisorCalidad getSupervisorCalidad() {
        return userSuperCalidad;
    }

    public static void cargarAdministrativo(Administrativo usuarioLogueado) {
        userAdministrativo = usuarioLogueado;
    }

    public static Administrativo getAdministrativo() {
        return userAdministrativo;
    }

    public static void borrarUsuario() {
        userSuperLinea = null;
        userSuperCalidad = null;
        userAdministrativo = null;
    }

    public static ArrayList<Usuario> getArrayUsuarios() {
        return arrayUsuarios;
    }
    
    public static void actualizarArrayUsuarios(ArrayList<Usuario> array){
        arrayUsuarios = array;
    }

    // L??NEAS
    public static ArrayList<Linea> getArrayLineas() {
        return arrayLineas;
    }

    // ??RDENES
    public static ArrayList<OrdenProduccion> getArrayOrdenes() {
        return arrayOrdenes;
    }

    public static void guardarOP(OrdenProduccion op) {
        arrayOrdenes.add(op);
    }

    public static void actualizarOP(ArrayList<OrdenProduccion> op) {
        arrayOrdenes = op;
    }

    // MODELOS
    public static ArrayList<Modelo> getArrayModelos() {
        return arrayModelos;
    }

    public static void addModelo(Modelo modelo) {
        arrayModelos.add(modelo);
    }

    // TURNOS
    public static ArrayList<Turno> getArrayTurnos() {
        return arrayTurnos;
    }

    // HORAS
    public static ArrayList<Hora> getArrayHoras() {
        return arrayHoras;
    }

    public static void actualizarHoras(ArrayList<Hora> nuevoArrayHoras) {
        arrayHoras = nuevoArrayHoras;
    }

    public static void addHora(Hora hora) {
        arrayHoras.add(hora);
    }

    // COLORES    
    public static ArrayList<Color> getArrayColores() {
        return arrayColores;
    }

    public static void addColor(Color color) {
        arrayColores.add(color);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(153, 153, 153));

        jMenu1.setText("Sistema");

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalir);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuSalir;
    // End of variables declaration//GEN-END:variables

}
