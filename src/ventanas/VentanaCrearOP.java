package ventanas;

import com.leguizamon.dissist.Color;
import com.leguizamon.dissist.Colores;
import com.leguizamon.dissist.Linea;
import com.leguizamon.dissist.Lineas;
import com.leguizamon.dissist.MisFunciones;
import com.leguizamon.dissist.Modelo;
import com.leguizamon.dissist.Modelos;
import com.leguizamon.dissist.Ordenes;
import com.leguizamon.dissist.Turno;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class VentanaCrearOP extends javax.swing.JInternalFrame {

    private final ArrayList<Linea> arrayLineas;
    private final Turno turnoActual;
    private final ArrayList<Modelo> modelos;
    private ArrayList<Color> arrayColores;
    private final int horaActual;

    public VentanaCrearOP() {
        initComponents();
        MisFunciones.configVentana(this);
        txtId.requestFocus();

        Calendar cal = Calendar.getInstance();
        horaActual = cal.get(Calendar.HOUR_OF_DAY);

        Lineas lineas = new Lineas();
        arrayLineas = lineas.getArrayLineas();
        for (int i = 0; i < arrayLineas.size(); i++) {
            cbLinea.addItem(String.valueOf(arrayLineas.get(i).getNumeroLinea()));
        }

        // Obtenemos el turno al que pertenece la hora actual
        turnoActual = MisFunciones.getTurnoByHora(horaActual);

        // Asginamos los valores a los JTextFields
        txtTurno.setText(turnoActual.getNombre());
        lblHoras.setText("De " + MisFunciones.completarHora(turnoActual.getInicio()) + " a " + MisFunciones.completarHora(turnoActual.getFin()));
        txtHoraInicio.setText(MisFunciones.completarHora(horaActual));

        Modelos m = new Modelos();
        modelos = m.getArrayModelos();
        for (int i = 0; i < modelos.size(); i++) {
            cbModelo.addItem(String.valueOf(modelos.get(i).getSKU()));
        }

        txtId.setText(String.valueOf(MisFunciones.getProximoNumeroOrden()));

    }

    public JComboBox<String> getCbLinea() {
        return cbLinea;
    }

    public void setCbLinea(JComboBox<String> cbLinea) {
        this.cbLinea = cbLinea;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrear = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        cbLinea = new javax.swing.JComboBox<>();
        cbModelo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        cbColor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lblHoras = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTurno = new javax.swing.JTextField();
        txtHoraInicio = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();

        setTitle("INICIAR ORDEN DE PRODUCCIÓN");
        setFrameIcon(null);
        setMinimumSize(new java.awt.Dimension(200, 100));
        setPreferredSize(new java.awt.Dimension(700, 300));

        btnCrear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCrear.setText("INICIAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 190));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nº de Orden");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nº de Linea");

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtId.setFocusable(false);

        cbLinea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbModelo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbModeloActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Modelo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Turno");

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescripcion.setText("Nombre del Modelo");

        cbColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbColorActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Color");

        lblHoras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHoras.setText("Horarios");

        lblColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblColor.setText("Descripción del Color");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Hora de Inicio");

        txtTurno.setEditable(false);
        txtTurno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtHoraInicio.setEditable(false);
        txtHoraInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbLinea, 0, 100, Short.MAX_VALUE)
                    .addComponent(txtId)
                    .addComponent(txtTurno))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHoraInicio)
                    .addComponent(cbColor, 0, 155, Short.MAX_VALUE)
                    .addComponent(cbModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblColor))
                            .addComponent(cbColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(btnCrear)
                .addGap(55, 55, 55)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnCrear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        int numeroOrden = Integer.parseInt(txtId.getText());
        int linea = Integer.parseInt(cbLinea.getSelectedItem().toString());
        String modelo = cbModelo.getSelectedItem().toString();
        String color = cbColor.getSelectedItem().toString();

        Ordenes ordenes = new Ordenes();
        ordenes.iniciarOP(numeroOrden, linea, modelo, color, turnoActual, horaActual);
        dispose();
        VentanaGestionarOP v = new VentanaGestionarOP();

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        VentanaGestionarOP v = new VentanaGestionarOP();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbModeloActionPerformed
        String sku = cbModelo.getSelectedItem().toString();
        for (Modelo modelo : modelos) {
            if (modelo.getSKU().equals(sku)) {
                lblDescripcion.setText(modelo.getDescripcion());

                Colores c = new Colores();
                arrayColores = c.getArrayColores();
                cbColor.removeAllItems();
                for (Color color : arrayColores) {
                    if (color.getSku().equals(sku)) {
                        cbColor.addItem(color.getCodigo());
                    }
                }
                break;
            }
        }

    }//GEN-LAST:event_cbModeloActionPerformed

    private void cbColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbColorActionPerformed
        if (cbColor.getSelectedIndex() > -1) {
            String codigo = cbColor.getSelectedItem().toString();

            for (Color c : arrayColores) {
                if (c.getCodigo().equals(codigo)) {
                    lblColor.setText(c.getDescripcion());
                }
            }
        }
    }//GEN-LAST:event_cbColorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox<String> cbColor;
    private javax.swing.JComboBox<String> cbLinea;
    private javax.swing.JComboBox<String> cbModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtTurno;
    // End of variables declaration//GEN-END:variables
}