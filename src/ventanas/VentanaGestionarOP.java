package ventanas;

import com.leguizamon.dissist.Colores;
import com.leguizamon.dissist.Hora;
import com.leguizamon.dissist.Horas;
import com.leguizamon.dissist.Mdi;
import com.leguizamon.dissist.MisFunciones;
import com.leguizamon.dissist.Modelos;
import com.leguizamon.dissist.OrdenProduccion;
import com.leguizamon.dissist.Ordenes;
import com.leguizamon.dissist.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class VentanaGestionarOP extends javax.swing.JInternalFrame {

    private DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel modelObjetivos = new DefaultTableModel();
    private DefaultTableModel modelDefectos = new DefaultTableModel();
    private final ArrayList<OrdenProduccion> arrayOrdenes;
    private ArrayList<Hora> arrayHoras;
    private int numeroOrden;
    private int totalHoras = 0;
    private int totalObjetivos = 0;
    private OrdenProduccion ordenProduccion = new OrdenProduccion();
    private int idHoraSeleccionada;
    DefaultTableCellRenderer centrador;

    /**
     * Creates new form VentanaGestionarOP
     */
    public VentanaGestionarOP() {
        initComponents();
        MisFunciones.configVentana(this);

        arrayOrdenes = Mdi.getArrayOrdenes();
        arrayHoras = Mdi.getArrayHoras();

        centrador = new DefaultTableCellRenderer();
        centrador.setHorizontalAlignment(SwingConstants.CENTER);

        setModelo(arrayOrdenes);

        // Lo que sucede cuando se selecciona una OP de la tabla
        tblOrdenes.getSelectionModel().addListSelectionListener((ListSelectionEvent evt) -> {
            totalHoras = 0;
            totalObjetivos = 0;
            if (tblOrdenes.getSelectedRowCount() > 0) {
                int fila = tblOrdenes.getSelectedRow();
                numeroOrden = Integer.parseInt(model.getValueAt(fila, 0).toString());

                ordenProduccion = MisFunciones.getOrdenProduccionByNumero(numeroOrden);

                gestionarBotones(model.getValueAt(fila, 7).toString());

                // Cargamos los objetivos de la orden de producción seleccionada
                setModeloObjetivos();
                Modelos m = new Modelos();
                String descripcionModelo = m.getModeloBySku(ordenProduccion.getModelo());

                Colores c = new Colores();
                String descripcionColor = c.getColorByCodigo(ordenProduccion.getModelo(), ordenProduccion.getColor());

                lblModelo.setText("Modelo: " + descripcionModelo + " - Color: " + descripcionColor);
                
                // cargamos los defectos que correspondan a la OP seleccionada
                setModeloDefectos();

            } else {
                btnPausar.setEnabled(false);
                btnReanudar.setEnabled(false);
                btnFinalizar.setEnabled(false);
                btnNuevoObjetivo.setEnabled(false);
            }
        });

        tblObjetivos.getSelectionModel().addListSelectionListener((ListSelectionEvent evt) -> {
            if (tblObjetivos.getSelectedRowCount() > 0) {
                btnEditarObjetivo.setEnabled(true);
                btnQuitarObjetivo.setEnabled(true);

                int fila = tblObjetivos.getSelectedRow();
                idHoraSeleccionada = Integer.parseInt(modelObjetivos.getValueAt(fila, 0).toString());
            } else {
                btnEditarObjetivo.setEnabled(false);
                btnQuitarObjetivo.setEnabled(false);
            }
        });
    }

    /**
     * Llena la tabla de Órdenes de Producción
     *
     * @param arrayOrdenes
     */
    private void setModelo(ArrayList<OrdenProduccion> arrayOrdenes) {
        String[] cabecera = {"Nº de Orden", "DNI", "Nº de línea", "Modelo", "Color", "Turno", "Fecha", "Estado"};
        model.setColumnIdentifiers(cabecera);
        Object[] datos = new Object[model.getColumnCount()];
        for (OrdenProduccion orden : arrayOrdenes) {
            datos[0] = orden.getNumeroOrden();
            datos[1] = orden.getDni();
            datos[2] = orden.getNumeroLinea();
            datos[3] = orden.getModelo();
            datos[4] = orden.getColor();
            datos[5] = orden.getTurno().getNombre();
            datos[6] = orden.getFecha();
            datos[7] = orden.getEstado();
            model.addRow(datos);
        }
        tblOrdenes.setModel(model);

        for (int col = 0; col < 8; col++) {
            tblOrdenes.getColumnModel().getColumn(col).setCellRenderer(centrador);
        }

        RowSorter<TableModel> ordenarPorNumeroOrden = new TableRowSorter<>(model);
        tblOrdenes.setRowSorter(ordenarPorNumeroOrden);
        tblOrdenes.getRowSorter().toggleSortOrder(0);
    }

    private void setModeloObjetivos() {
        totalObjetivos = 0;
        totalHoras = 0;

        // Tabla Objetivos
        String[] cabecera = {"id", "Nº de Orden", "Fecha", "Hora", "Objetivos"};
        modelObjetivos.setColumnIdentifiers(cabecera);
        Object[] datos = new Object[modelObjetivos.getColumnCount()];

        modelObjetivos.setRowCount(0);

        for (Hora obj : arrayHoras) {
            if (numeroOrden == obj.getNumeroOrden()) {
                datos[0] = obj.getId();
                datos[1] = obj.getNumeroOrden();
                datos[2] = obj.getFecha();
                datos[3] = MisFunciones.completarHora(obj.getHora());
                datos[4] = obj.getObjetivo();
                modelObjetivos.addRow(datos);
                totalHoras++;
                totalObjetivos += obj.getObjetivo();
            }
        }
        tblObjetivos.setModel(modelObjetivos);
        for (int col = 0; col < 5; col++) {
            tblObjetivos.getColumnModel().getColumn(col).setCellRenderer(centrador);
        }

        RowSorter<TableModel> ordenarPorHora = new TableRowSorter<>(modelObjetivos);
        tblObjetivos.setRowSorter(ordenarPorHora);
        tblObjetivos.getRowSorter().toggleSortOrder(3);

        lblCantidadHoras.setText(String.valueOf(totalHoras));
        lblCantidadObjetivos.setText(String.valueOf(totalObjetivos));
    }

    private void setModeloDefectos(){
        String[] cabecera ={"Tipo de defecto", "Cantidad"};
        modelDefectos.setColumnIdentifiers(cabecera);
        tablaDefectos.setModel(modelDefectos);
    }
    /**
     * Permite seleccionar una fila de la tabla de Órdenes
     *
     * @param ordenProduccion
     */
    public void seleccionarOrden(OrdenProduccion ordenProduccion) {
        for (int i = 0; i < tblOrdenes.getRowCount(); i++) {
            if (Integer.parseInt(tblOrdenes.getValueAt(i, 0).toString()) == ordenProduccion.getNumeroOrden()) {
                tblOrdenes.changeSelection(i, 0, false, false);
                break;
            }
        }
    }

    private void gestionarBotones(String estado) {
        switch (estado) {
            case "INICIADO" : {
                btnPausar.setEnabled(true);
                btnReanudar.setEnabled(false);
                btnFinalizar.setEnabled(true);
                btnNuevoObjetivo.setEnabled(true);
                btnEditarObjetivo.setEnabled(false);
                btnQuitarObjetivo.setEnabled(false);
            }
            case "PAUSADO" : {
                btnPausar.setEnabled(false);
                btnReanudar.setEnabled(true);
                btnFinalizar.setEnabled(false);
                btnNuevoObjetivo.setEnabled(false);
                btnEditarObjetivo.setEnabled(false);
                btnQuitarObjetivo.setEnabled(false);
            }
            case "FINALIZADO" : {
                btnPausar.setEnabled(false);
                btnReanudar.setEnabled(false);
                btnFinalizar.setEnabled(false);
                btnNuevoObjetivo.setEnabled(false);
                btnEditarObjetivo.setEnabled(false);
                btnQuitarObjetivo.setEnabled(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevo = new javax.swing.JButton();
        btnPausar = new javax.swing.JButton();
        btnReanudar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdenes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblObjetivos = new javax.swing.JTable();
        btnNuevoObjetivo = new javax.swing.JButton();
        lblHoras = new javax.swing.JLabel();
        lblObjetivos = new javax.swing.JLabel();
        lblCantidadHoras = new javax.swing.JLabel();
        lblCantidadObjetivos = new javax.swing.JLabel();
        btnEditarObjetivo = new javax.swing.JButton();
        btnQuitarObjetivo = new javax.swing.JButton();
        lblModelo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCorrectos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDefectuosos = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDefectos = new javax.swing.JTable();

        setTitle("GESTIONAR ORDEN DE PRODUCCIÓN");
        setFrameIcon(null);

        btnNuevo.setText("NUEVA OP");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnPausar.setText("PAUSAR OP");
        btnPausar.setEnabled(false);
        btnPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausarActionPerformed(evt);
            }
        });

        btnReanudar.setText("REANUDAR OP");
        btnReanudar.setEnabled(false);
        btnReanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReanudarActionPerformed(evt);
            }
        });

        btnFinalizar.setText("FINALIZAR OP");
        btnFinalizar.setEnabled(false);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(255, 51, 51));
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("CERRAR SESION");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tblOrdenes);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("OBJETIVOS");

        tblObjetivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblObjetivos);

        btnNuevoObjetivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevoObjetivo.setText("NUEVO");
        btnNuevoObjetivo.setEnabled(false);
        btnNuevoObjetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoObjetivoActionPerformed(evt);
            }
        });

        lblHoras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHoras.setText("Cantidad de Horas:");

        lblObjetivos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblObjetivos.setText("Total de Objetivos:");

        lblCantidadHoras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCantidadHoras.setText("0");

        lblCantidadObjetivos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCantidadObjetivos.setText("0");

        btnEditarObjetivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditarObjetivo.setText("EDITAR");
        btnEditarObjetivo.setEnabled(false);
        btnEditarObjetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarObjetivoActionPerformed(evt);
            }
        });

        btnQuitarObjetivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQuitarObjetivo.setText("QUITAR");
        btnQuitarObjetivo.setEnabled(false);
        btnQuitarObjetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarObjetivoActionPerformed(evt);
            }
        });

        lblModelo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblModelo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Pares Correctos:");

        txtCorrectos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCorrectos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCorrectos.setText("0");
        txtCorrectos.setBorder(null);

        jLabel3.setText("Pares defectuosos:");

        txtDefectuosos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDefectuosos.setText("0");
        txtDefectuosos.setBorder(null);

        tablaDefectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaDefectos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnPausar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnReanudar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblHoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblObjetivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCantidadHoras)
                                .addComponent(lblCantidadObjetivos)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCorrectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNuevoObjetivo)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarObjetivo)
                                .addGap(18, 18, 18)
                                .addComponent(btnQuitarObjetivo)
                                .addGap(18, 18, 18)
                                .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDefectuosos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnPausar)
                    .addComponent(btnReanudar)
                    .addComponent(btnFinalizar)
                    .addComponent(btnCerrarSesion))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnNuevoObjetivo)
                            .addComponent(btnEditarObjetivo)
                            .addComponent(btnQuitarObjetivo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoras)
                    .addComponent(lblCantidadHoras)
                    .addComponent(jLabel3)
                    .addComponent(txtDefectuosos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblObjetivos)
                            .addComponent(lblCantidadObjetivos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCorrectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Ordenes o = new Ordenes();
        if (o.tieneOpPendientes()) {
            JOptionPane.showMessageDialog(null, "Tiene Órdenes de Producción sin finalizar");
        } else {
            dispose();
            VentanaCrearOP v = new VentanaCrearOP();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausarActionPerformed
        Ordenes o = new Ordenes();
        o.pausarOP(ordenProduccion);
        ArrayList<OrdenProduccion> op;// = new ArrayList<>();
        op = Mdi.getArrayOrdenes();
        model.setRowCount(0);
        setModelo(op);

    }//GEN-LAST:event_btnPausarActionPerformed

    private void btnReanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReanudarActionPerformed
        dispose();
        VentanaReanudarOP v = new VentanaReanudarOP(ordenProduccion);
    }//GEN-LAST:event_btnReanudarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        Ordenes o = new Ordenes();
        o.finalizarOP(ordenProduccion);
        ArrayList<OrdenProduccion> op = Mdi.getArrayOrdenes();
        model.setRowCount(0);
        setModelo(op);
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Mdi.borrarUsuario();
        dispose();
        Usuario u = new Usuario();
        u.mostrarVentanaLogin();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnNuevoObjetivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoObjetivoActionPerformed
        VentanaCrearObjetivo v = new VentanaCrearObjetivo(ordenProduccion);
        dispose();
    }//GEN-LAST:event_btnNuevoObjetivoActionPerformed

    private void btnQuitarObjetivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarObjetivoActionPerformed
        ArrayList<Hora> nuevoArrayHoras = new ArrayList<>();
        for (Hora hora : arrayHoras) {
            if (hora.getId() != idHoraSeleccionada) {
                nuevoArrayHoras.add(hora);
            }
        }
        Horas horas = new Horas();
        horas.actualizarHoras(nuevoArrayHoras);
        arrayHoras = horas.getArrayHoras();
        modelObjetivos.setRowCount(0);
        setModeloObjetivos();
    }//GEN-LAST:event_btnQuitarObjetivoActionPerformed

    private void btnEditarObjetivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarObjetivoActionPerformed
        dispose();
        Hora hora = MisFunciones.getHoraById(idHoraSeleccionada);
        VentanaEditarObjetivo v = new VentanaEditarObjetivo(ordenProduccion, hora);
    }//GEN-LAST:event_btnEditarObjetivoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEditarObjetivo;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevoObjetivo;
    private javax.swing.JButton btnPausar;
    private javax.swing.JButton btnQuitarObjetivo;
    private javax.swing.JButton btnReanudar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCantidadHoras;
    private javax.swing.JLabel lblCantidadObjetivos;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblObjetivos;
    private javax.swing.JTable tablaDefectos;
    private javax.swing.JTable tblObjetivos;
    private javax.swing.JTable tblOrdenes;
    private javax.swing.JTextField txtCorrectos;
    private javax.swing.JTextField txtDefectuosos;
    // End of variables declaration//GEN-END:variables
}
