/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import com.leguizamon.dissist.Mdi;
import com.leguizamon.dissist.MisFunciones;
import com.leguizamon.dissist.Usuario;

/**
 *
 * @author Luis
 */
public class VentanaAdministrador extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaAdministrador
     */
    public VentanaAdministrador() {
        initComponents();
        MisFunciones.configVentana(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnModelos = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnGestionarUsuarios = new javax.swing.JButton();

        btnModelos.setText("GESTIONAR MODELOS");
        btnModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModelosActionPerformed(evt);
            }
        });

        btnCerrarSesion.setText("CERRAR SESIÓN");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnGestionarUsuarios.setText("GESTIONAR USUARIOS");
        btnGestionarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModelos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGestionarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnGestionarUsuarios)
                .addGap(18, 18, 18)
                .addComponent(btnModelos)
                .addGap(18, 18, 18)
                .addComponent(btnCerrarSesion)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModelosActionPerformed
        VentanaGestionarModelo v = new VentanaGestionarModelo();
    }//GEN-LAST:event_btnModelosActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Mdi.borrarUsuario();
        dispose();
        Usuario u = new Usuario();
        u.mostrarVentanaLogin();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGestionarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarUsuariosActionPerformed
        VentanaGestionarUsuarios v = new VentanaGestionarUsuarios();
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnGestionarUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnGestionarUsuarios;
    private javax.swing.JButton btnModelos;
    private javax.swing.JButton btnSalir;
    // End of variables declaration//GEN-END:variables
}
