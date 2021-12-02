/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

import Chat_P2P.FachadaAplicacion;
import static definiciones.Definiciones.*;
import gui.VLogin;
import modelos.Mensaje;

/**
 *
 * @author ruben
 */
public class LoginPanel_SignIn extends javax.swing.JPanel {

    private final VLogin vl;
    
    public LoginPanel_SignIn(VLogin vl) {
        initComponents();
        this.vl = vl;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonRegistrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        password1 = new javax.swing.JPasswordField();
        buttonIniciarSesion = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        password2 = new javax.swing.JPasswordField();
        mensajeError = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(255, 255));
        setMinimumSize(new java.awt.Dimension(255, 255));
        setPreferredSize(new java.awt.Dimension(255, 255));

        buttonRegistrar.setText("Registrarse");
        buttonRegistrar.setName("buttonRegistrar"); // NOI18N
        buttonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Username");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText("Repetir");
        jLabel3.setName("jLabel3"); // NOI18N

        txtUsername.setName("txtUsername"); // NOI18N

        password1.setName("password1"); // NOI18N
        password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password1ActionPerformed(evt);
            }
        });

        buttonIniciarSesion.setText("Iniciar Sesión");
        buttonIniciarSesion.setName("buttonIniciarSesion"); // NOI18N
        buttonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIniciarSesionActionPerformed(evt);
            }
        });

        jLabel4.setText("Password");
        jLabel4.setName("jLabel4"); // NOI18N

        password2.setName("password2"); // NOI18N
        password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password2ActionPerformed(evt);
            }
        });

        mensajeError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensajeError.setText("jLabel1");
        mensajeError.setName("mensajeError"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(mensajeError, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(buttonIniciarSesion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 109, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(buttonRegistrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 103, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(9, 9, 9)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel2)
                                        .add(18, 18, 18)
                                        .add(txtUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(layout.createSequentialGroup()
                                                .add(jLabel3)
                                                .add(39, 39, 39))
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(18, 18, 18)))
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(layout.createSequentialGroup()
                                                .add(password2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(0, 1, Short.MAX_VALUE))
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                .add(0, 0, Short.MAX_VALUE)
                                                .add(password1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(19, 19, 19)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(password1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .add(21, 21, 21)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(password2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(mensajeError)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(buttonIniciarSesion)
                    .add(buttonRegistrar))
                .add(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password1ActionPerformed

    private void password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password2ActionPerformed

    private void buttonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIniciarSesionActionPerformed
        // TODO add your handling code here:
        vl.mostrarIniciarSesion();
    }//GEN-LAST:event_buttonIniciarSesionActionPerformed

    private void buttonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarActionPerformed
        // TODO add your handling code here:
        if((!txtUsername.getText().equals("")) && (!password1.getPassword().equals(""))){
            if(String.valueOf(password1.getPassword()).equals(String.valueOf(password2.getPassword()))){
                try{
                    Mensaje m = vl.registrarUsuario(txtUsername.getText(),String.valueOf(password1.getPassword()));
                    if(m.getCodigo() == FRACASO){
                        mensajeError.setText(m.getMensaje());
                    }
                }catch(Exception e){
                    System.out.println("Exception: " + e);
                }
            }else{
                mensajeError.setText(PASSWORDS_NO_COINCIDEN);
            }
        }else{
            mensajeError.setText(CAMPOS_INCOMPLETOS);
        }
    }//GEN-LAST:event_buttonRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonIniciarSesion;
    private javax.swing.JButton buttonRegistrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel mensajeError;
    private javax.swing.JPasswordField password1;
    private javax.swing.JPasswordField password2;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
