package ventanas;

import com.leguizamon.dissist.Hora;
import com.leguizamon.dissist.Horas;
import com.leguizamon.dissist.MisFunciones;
import com.leguizamon.dissist.OrdenProduccion;
import com.leguizamon.dissist.Turno;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VentanaEditarObjetivo extends javax.swing.JInternalFrame {

    Horas horas = new Horas();
    private final OrdenProduccion ordenProduccion;
    private final Hora hora;
    private final Turno turno;
    ArrayList<Hora> arrayHoras;

    /**
     * Creates new form VentanaNuevoObjetivo
     *
     * @param ordenProduccion
     * @param hora
     */
    public VentanaEditarObjetivo(OrdenProduccion ordenProduccion, Hora hora) {
        this.ordenProduccion = ordenProduccion;
        this.hora = hora;
        turno = ordenProduccion.getTurno();
        arrayHoras = horas.getArrayHoras();

        initComponents();

        MisFunciones.configVentana(this);

        txtNumeroOrden.setText(String.valueOf(ordenProduccion.getNumeroOrden()));
        txtTurno.setText(turno.getNombre());
        txtHora.setText(String.valueOf(hora.getHora()));
        txtObjetivo.setText(String.valueOf(hora.getObjetivo()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTurno = new javax.swing.JTextField();
        txtObjetivo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNumeroOrden = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();

        setTitle("AGREGAR OBJETIVO");
        setFrameIcon(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Turno");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Hora");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Objetivo");

        txtTurno.setEditable(false);
        txtTurno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTurno.setFocusable(false);

        txtObjetivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nº Orden");

        txtNumeroOrden.setEditable(false);
        txtNumeroOrden.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNumeroOrden.setFocusable(false);

        txtHora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTurno)
                            .addComponent(txtObjetivo, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(txtNumeroOrden)
                            .addComponent(txtHora))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNumeroOrden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtObjetivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(36, 36, 36))
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        VentanaGestionarOP v = new VentanaGestionarOP();
        v.seleccionarOrden(ordenProduccion);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        ArrayList<Hora> nuevoArrayHoras = new ArrayList<>();
        if (txtObjetivo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el objetivo");
        } else {
            for (Hora h : arrayHoras) {
                if (h.getId() == hora.getId()) {
                    h.setObjetivo(Integer.parseInt(txtObjetivo.getText()));
                }
                nuevoArrayHoras.add(h);
            }
            Horas horas = new Horas();
            horas.actualizarHoras(nuevoArrayHoras);

            dispose();
            VentanaGestionarOP v = new VentanaGestionarOP();
            v.seleccionarOrden(ordenProduccion);

        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNumeroOrden;
    private javax.swing.JTextField txtObjetivo;
    private javax.swing.JTextField txtTurno;
    // End of variables declaration//GEN-END:variables
}
