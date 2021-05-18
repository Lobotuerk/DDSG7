package ventanas;

import com.leguizamon.dissist.Color;
import com.leguizamon.dissist.Colores;
import com.leguizamon.dissist.MisFunciones;
import com.leguizamon.dissist.Modelo;
import com.leguizamon.dissist.Modelos;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VentanaGestionarModelo extends javax.swing.JInternalFrame {

    private final DefaultTableModel model = new DefaultTableModel();
    private final DefaultTableModel modelColores = new DefaultTableModel();
    private ArrayList<Modelo> modelos = new ArrayList<Modelo>();
    private ArrayList<Color> colores = new ArrayList<Color>();
    private String sku;
    DefaultTableCellRenderer centrador;

    /**
     * Creates new form VentanaGestionarModelo
     */
    public VentanaGestionarModelo() {
        initComponents();

        MisFunciones.configVentana(this);

        centrador = new DefaultTableCellRenderer();
        centrador.setHorizontalAlignment(SwingConstants.CENTER);

        cargarModelos();

        // LISTENER línea seleccionada
        tblModelos.getSelectionModel().addListSelectionListener((ListSelectionEvent evt) -> {
            if (tblModelos.getSelectedRowCount() > 0) {
                btnAgregarColor.setEnabled(true);
                cargarColores();
            } else {
                btnAgregarColor.setEnabled(false);
            }
        });
    }

    public final void cargarModelos() {
        Modelos m = new Modelos();
        modelos = m.getArrayModelos();
        String[] cabecera = {"SKU", "Descripción"};
        model.setColumnIdentifiers(cabecera);
        Object[] datos = new Object[model.getColumnCount()];
        for (Modelo modelo : modelos) {
            datos[0] = modelo.getSKU();
            datos[1] = modelo.getDescripcion();
            model.addRow(datos);
        }
        tblModelos.setModel(model);
        for (int col = 0; col < 2; col++) {
            tblModelos.getColumnModel().getColumn(col).setCellRenderer(centrador);
        }
    }

    public void cargarColores() {
        int fila = tblModelos.getSelectedRow();
        sku = model.getValueAt(fila, 0).toString();

        // Tabla Colores
        String[] cabeceraColores = {"SKU", "Código", "Descripción"};
        modelColores.setColumnIdentifiers(cabeceraColores);
        Colores c = new Colores();
        colores = c.getArrayColores();
        modelColores.setRowCount(0);
        for (Color color : colores) {
            if (color.getSku().equals(sku)) {
                Object[] datosColores = new Object[modelColores.getColumnCount()];
                datosColores[0] = color.getSku();
                datosColores[1] = color.getCodigo();
                datosColores[2] = color.getDescripcion();
                modelColores.addRow(datosColores);
            }
        }
        tblColores.setModel(modelColores);
        for (int col = 0; col < 3; col++) {
            tblColores.getColumnModel().getColumn(col).setCellRenderer(centrador);
        }
    }

    public void seleccionarModelo(String sku) {
        for (int i = 0; i < tblModelos.getRowCount(); i++) {
            if (tblModelos.getValueAt(i, 0).toString().equals(sku)) {
                tblModelos.changeSelection(i, 1, false, false);
                break;
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

        btnNuevoModelo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblModelos = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblColores = new javax.swing.JTable();
        btnAgregarColor = new javax.swing.JButton();

        setTitle("GESTIONAR MODELOS");
        setFrameIcon(null);

        btnNuevoModelo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevoModelo.setText("NUEVO MODELO");
        btnNuevoModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoModeloActionPerformed(evt);
            }
        });

        tblModelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblModelos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblModelos);

        btnCerrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Colores disponibles");

        tblColores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblColores);

        btnAgregarColor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarColor.setText("AGREGAR COLOR");
        btnAgregarColor.setEnabled(false);
        btnAgregarColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNuevoModelo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarColor))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(btnCerrar)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoModelo)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnAgregarColor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnNuevoModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoModeloActionPerformed
        dispose();
        VentanaCrearModelo v = new VentanaCrearModelo();
    }//GEN-LAST:event_btnNuevoModeloActionPerformed

    private void btnAgregarColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarColorActionPerformed
        dispose();
        VentanaAgregarColor v = new VentanaAgregarColor(sku);
    }//GEN-LAST:event_btnAgregarColorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarColor;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnNuevoModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblColores;
    private javax.swing.JTable tblModelos;
    // End of variables declaration//GEN-END:variables
}
