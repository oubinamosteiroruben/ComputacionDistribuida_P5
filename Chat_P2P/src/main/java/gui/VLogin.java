/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Chat_P2P.FachadaAplicacion;
import static definiciones.Definiciones.NOMBRE_APP;
import static definiciones.Definiciones.RUTA_ICON;
import gui.paneles.*;
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import modelos.Mensaje;

/**
 *
 * @author ruben
 */
public class VLogin extends javax.swing.JFrame {

    private final FachadaAplicacion fa;
    
    public VLogin(FachadaAplicacion fa) {
        
        this.fa = fa;
        initComponents();
        mostrarIniciarSesion();
        this.setTitle(NOMBRE_APP);
        //this.icon.setIcon(new ImageIcon("src/main/java/img/iconLogo.png"));
        this.setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new LoginPanel_Login(this);
        icon = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(80, 0), new java.awt.Dimension(80, 0), new java.awt.Dimension(80, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(110, 221, 241));
        setMaximumSize(new java.awt.Dimension(279, 382));
        setMinimumSize(new java.awt.Dimension(279, 382));
        setPreferredSize(new java.awt.Dimension(279, 412));
        setSize(311,340);

        loginPanel.setMaximumSize(new java.awt.Dimension(255, 255));
        loginPanel.setMinimumSize(new java.awt.Dimension(255, 255));
        loginPanel.setName(""); // NOI18N
        loginPanel.setPreferredSize(new java.awt.Dimension(255, 255));

        org.jdesktop.layout.GroupLayout loginPanelLayout = new org.jdesktop.layout.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 255, Short.MAX_VALUE)
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 346, Short.MAX_VALUE)
        );

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIconTextGap(1);
        icon.setName("icon"); // NOI18N

        filler1.setName("filler1"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(loginPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(filler1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(icon, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(39, 39, 39)
                        .add(filler1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .add(icon, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(loginPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 346, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel loginPanel;
    // End of variables declaration//GEN-END:variables


    public void setIcon(){
        ImageIcon imgIcon = new ImageIcon(RUTA_ICON);
        Image imgEscalada = imgIcon.getImage().getScaledInstance(97, 86, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imgEscalada);
        this.icon.setIcon(iconoEscalado);
    }
    
    public void mostrarIniciarSesion(){
        actualizarLoginPanel(new LoginPanel_Login(this));
    }
    
    public void mostrarRegistrar(){
        actualizarLoginPanel(new LoginPanel_SignIn(this));
    }
    
    public void actualizarLoginPanel(JPanel newPanel){
        newPanel.setSize(this.loginPanel.getSize());
        newPanel.setVisible(true);
        
        this.loginPanel.removeAll();
        this.loginPanel.add(newPanel, BorderLayout.CENTER);
        this.loginPanel.revalidate();
        this.loginPanel.repaint();
        this.loginPanel.setVisible(true);
    }
    
    public Boolean iniciarSesion(String username, String password) throws Exception{
        return this.fa.iniciarSesion(username,password);
    }
    
    public Boolean registrarUsuario(String username, String password) throws Exception{
        return this.fa.registrarUsuario(username,password);
    }
}
