/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

import Chat_P2P.FachadaAplicacion;
import static definiciones.Definiciones.CAMPOS_INCOMPLETOS;
import static definiciones.Definiciones.DATOS_INCORRECTOS;
import static definiciones.Definiciones.ERROR_NORMAL;
import gui.FachadaGui;
import gui.VLogin;

/**
 *
 * @author ruben
 */
public class LoginPanel_Login extends javax.swing.JPanel {

    
    private final VLogin vl;
    
    public LoginPanel_Login(VLogin vl) {
        this.vl = vl;
        initComponents();
        this.mensajeError.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mensajeError = new javax.swing.JLabel();
        buttonRegistrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        buttonEntrar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(255, 348));
        setMinimumSize(new java.awt.Dimension(255, 348));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(255, 348));

        mensajeError.setForeground(new java.awt.Color(255, 51, 51));
        mensajeError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensajeError.setText("mensaje de error");
        mensajeError.setName("mensajeError"); // NOI18N

        buttonRegistrar.setText("Registrarse");
        buttonRegistrar.setName("buttonRegistrar"); // NOI18N
        buttonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Username");
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText("Password");
        jLabel3.setName("jLabel3"); // NOI18N

        txtUsername.setName("txtUsername"); // NOI18N

        txtPassword.setName("txtPassword"); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        buttonEntrar.setText("Entrar");
        buttonEntrar.setName("buttonEntrar"); // NOI18N
        buttonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntrarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(40, 40, 40)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(txtPassword, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .add(txtUsername))
                .addContainerGap(11, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(mensajeError, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(buttonRegistrar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(buttonEntrar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(34, 34, 34)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(19, 19, 19)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(txtPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(28, 28, 28)
                .add(mensajeError, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(39, 39, 39)
                .add(buttonEntrar)
                .add(18, 18, 18)
                .add(buttonRegistrar)
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void buttonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarActionPerformed
        // TODO add your handling code here:
        vl.mostrarRegistrar();
    }//GEN-LAST:event_buttonRegistrarActionPerformed

    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntrarActionPerformed
        try{
            if((!this.txtUsername.getText().equals("")) && (!String.valueOf(this.txtPassword.getPassword()).equals(""))){
                boolean resultado = vl.iniciarSesion(this.txtUsername.getText(), String.valueOf(this.txtPassword.getPassword()));
                if(!resultado){
                    //mostrar mensaje de usuario incorrecto
                    this.mensajeError.setText(DATOS_INCORRECTOS);
                    this.mensajeError.setVisible(true);
                } else{
                    this.mensajeError.setVisible(false);
                }
            } else{
                this.mensajeError.setText(CAMPOS_INCOMPLETOS);
            }
            
        } catch(Exception e){
            System.out.println("Exception: " + e);
            // si los campos est??n vacios, mostrar mensaje
            this.mensajeError.setText(ERROR_NORMAL);
            this.mensajeError.setVisible(true);
        }
    }//GEN-LAST:event_buttonEntrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEntrar;
    private javax.swing.JButton buttonRegistrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel mensajeError;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
