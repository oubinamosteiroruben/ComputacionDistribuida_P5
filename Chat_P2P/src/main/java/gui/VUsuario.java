/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Chat_P2P.FachadaAplicacion;
import gui.paneles.MainPanel;
import gui.paneles.SolicitudesPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import modelos.Mensaje;
import modelos.MensajeChat;
import modelos.Usuario;

public class VUsuario extends javax.swing.JFrame {

    private final FachadaAplicacion fa;
    private MainPanel mp;
    private SolicitudesPanel sp;
    
    public VUsuario(FachadaAplicacion fa) {
        initComponents();
        this.fa = fa;
        mp = new MainPanel(this);
        mp.setSize(this.mainPanel.getSize());
        sp = new SolicitudesPanel(this);
        sp.setSize(this.mainPanel.getSize());
        mostrarMainUsuarios();
        mostrarNumeroSolicitudes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setMaximumSize(new java.awt.Dimension(542, 454));
        mainPanel.setMinimumSize(new java.awt.Dimension(542, 454));
        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.layout.GroupLayout mainPanelLayout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 542, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 454, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables


    public void mostrarMainUsuarios(){
        actualizarMainPanel(mp);
    }
    
    public void mostrarSolicitudes(){
        actualizarMainPanel(sp);
    }
    
    
    public void actualizarMainPanel(JPanel actualPanel){
        actualPanel.setVisible(true);
        
        this.mainPanel.removeAll();
        this.mainPanel.add(actualPanel, BorderLayout.CENTER);
        this.mainPanel.revalidate();
        this.mainPanel.repaint();
        this.mainPanel.setVisible(true);
    }
    
    public void actualizarAmigosConectados(ArrayList<String> amigos){
        this.mp.actualizarAmigosConectados(amigos);
    }
    
    public String getUsuarioActual(){
        return this.fa.getUsuarioActual();
    }
    
    public void enviarMensaje(MensajeChat mc) throws Exception{
        this.fa.enviarMensaje(mc);
    }
    
    public void recibirMensaje(MensajeChat mc){
        this.mp.recibirMensaje(mc);
    }
    
    public Boolean enviarPeticion(String usernameOrigen, String usernameDestino) throws Exception{
        return this.fa.enviarPeticion(usernameOrigen, usernameDestino);
    }
    
    public Boolean aceptarPeticion(String usernameOrigen, String usernameDestino) throws Exception{
        return this.fa.aceptarPeticion(usernameOrigen, usernameDestino);
    }
    
    public Boolean rechazarPeticion(String usernameOrigen, String usernameDestino) throws Exception{
        return this.fa.rechazarPeticion(usernameOrigen, usernameDestino);
    }
    
    public ArrayList<String> obtenerPeticiones() throws Exception{
        return this.fa.obtenerPeticiones(this.getUsuarioActual());
    }
    
    public void mostrarNumeroSolicitudes(){
        int numeroPeticiones = this.sp.getPeticiones().size();
        this.mp.mostrarNumeroSolicitudes(numeroPeticiones);
    }
    
    public void actualizarPeticiones(){
        this.sp.actualizarTablaPeticiones();
        this.mostrarNumeroSolicitudes();
    }
    
    /*
    
    public void actualizarPeticiones(ArrayList<String> peticiones){
        this.sp.actualizarPeticiones(peticiones);
    }
    
    
    public void actualizarAmigos(ArrayList<Usuario> amigos){
        this.mp.actualizarAmigos(amigos);
    }*/

}
