/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

import gui.VUsuario;
import gui.modelos.ModeloTablaAmigos;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import modelos.MensajeChat;
import modelos.Usuario;


public class MainPanel extends javax.swing.JPanel {

    private final VUsuario vu;
    
    private String amigoChatActual;
    
    private HashMap<String,ArrayList<MensajeChat>> conversaciones; 
    /**
     * Creates new form MainPanel
     */
    public MainPanel(VUsuario vu) {
        this.conversaciones = new HashMap<>();
        this.amigoChatActual = null;
        this.vu = vu;
        initComponents();
        this.textChat.setEditable(false);
        this.txtNombreAmigo.setText("Selecciona un amigo");
        this.txtMensaje.setEnabled(false);
        this.buttonEnviar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConectados = new javax.swing.JTable();
        buttonSolicitudes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelTitutlo = new javax.swing.JLabel();
        txtNombreAmigo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textChat = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        buttonEnviar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(542, 454));
        setMinimumSize(new java.awt.Dimension(542, 454));
        setPreferredSize(new java.awt.Dimension(542, 454));

        jPanel1.setMaximumSize(new java.awt.Dimension(170, 430));
        jPanel1.setMinimumSize(new java.awt.Dimension(170, 430));
        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tablaConectados.setModel(new ModeloTablaAmigos(this));
        tablaConectados.setName("tablaConectados"); // NOI18N
        tablaConectados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaConectadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaConectados);

        buttonSolicitudes.setText("Solicitudes");
        buttonSolicitudes.setName("buttonSolicitudes"); // NOI18N
        buttonSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSolicitudesActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Amigos");
        jLabel1.setName("jLabel1"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(buttonSolicitudes, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(27, 27, 27)
                .add(jLabel1)
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 284, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(27, 27, 27)
                .add(buttonSolicitudes)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(330, 430));
        jPanel2.setMinimumSize(new java.awt.Dimension(330, 430));
        jPanel2.setName("jPanel2"); // NOI18N

        labelTitutlo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitutlo.setText("Nombre App");
        labelTitutlo.setName("labelTitutlo"); // NOI18N

        txtNombreAmigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNombreAmigo.setText("nombreAmigo");
        txtNombreAmigo.setName("txtNombreAmigo"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        textChat.setName("textChat"); // NOI18N
        jScrollPane2.setViewportView(textChat);

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        txtMensaje.setColumns(20);
        txtMensaje.setLineWrap(true);
        txtMensaje.setRows(1);
        txtMensaje.setName("txtMensaje"); // NOI18N
        jScrollPane3.setViewportView(txtMensaje);

        buttonEnviar.setText("↑");
        buttonEnviar.setName("buttonEnviar"); // NOI18N
        buttonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnviarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jScrollPane2)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, labelTitutlo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2Layout.createSequentialGroup()
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buttonEnviar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, txtNombreAmigo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(labelTitutlo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .add(47, 47, 47)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 192, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(44, 44, 44)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(buttonEnviar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(32, 32, 32))
            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jPanel2Layout.createSequentialGroup()
                    .add(65, 65, 65)
                    .add(txtNombreAmigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(327, Short.MAX_VALUE)))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(421, Short.MAX_VALUE))
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(189, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(23, 23, 23)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSolicitudesActionPerformed
        // TODO add your handling code here:
        this.vu.mostrarSolicitudes();
    }//GEN-LAST:event_buttonSolicitudesActionPerformed

    private void tablaConectadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConectadosMouseClicked
        // TODO add your handling code here:
        this.txtMensaje.setEnabled(false);
        this.buttonEnviar.setEnabled(false);
        String amigo;
        ModeloTablaAmigos m;
        m = (ModeloTablaAmigos) this.tablaConectados.getModel();
        amigo = m.obtenerAmigo(this.tablaConectados.getSelectedRow());
        if (amigo != null) {
            this.amigoChatActual = amigo;
            actualizarChat();
            this.txtMensaje.setEnabled(true);
            this.buttonEnviar.setEnabled(true);
        }
    }//GEN-LAST:event_tablaConectadosMouseClicked

    private void buttonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnviarActionPerformed
        // TODO add your handling code here:
        try{
              
            if(!this.txtMensaje.getText().equals("") && this.amigoChatActual != null){
                MensajeChat mc = new MensajeChat(this.vu.getUsuarioActual(),amigoChatActual,this.txtMensaje.getText());
                this.conversaciones.get(amigoChatActual).add(mc);
                this.vu.enviarMensaje(mc);
                actualizarChat();
                this.txtMensaje.setText("");
            }
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }//GEN-LAST:event_buttonEnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEnviar;
    private javax.swing.JButton buttonSolicitudes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelTitutlo;
    private javax.swing.JTable tablaConectados;
    private javax.swing.JTextPane textChat;
    private javax.swing.JTextArea txtMensaje;
    private javax.swing.JLabel txtNombreAmigo;
    // End of variables declaration//GEN-END:variables

    public void actualizarAmigosConectados(ArrayList<String> amigos){
        HashMap<String,ArrayList<MensajeChat>> conversacionesAux = new HashMap<>();
        for(String a: amigos){
            if(this.conversaciones.get(a) == null){
                conversacionesAux.put(a,new ArrayList<>());
            }else{
                conversacionesAux.put(a, this.conversaciones.get(a));
            }
        }
        this.conversaciones = conversacionesAux;
        ((ModeloTablaAmigos) this.tablaConectados.getModel()).setFilas(this.conversaciones);
    }
    
    public void actualizarChat(){
        String contenido = "";
        if(this.amigoChatActual != null){
            ArrayList<MensajeChat> chat = this.conversaciones.get(this.amigoChatActual);
            if(chat == null){
                this.conversaciones.put(this.amigoChatActual, new ArrayList<>());
            }else{
                Boolean flag = false;
                for(MensajeChat mc: chat){
                    if(mc.getEmisor().equals(this.amigoChatActual) && !mc.isLeido()){
                        mc.setLeido(true);
                        flag = true;
                    }
                    contenido+=mc.getEmisor()+": " + mc.getCuerpo() + "\n";
                }
                if(flag){
                    ((ModeloTablaAmigos) this.tablaConectados.getModel()).setFilas(this.conversaciones);
                }
            }
        }
        this.textChat.setText(contenido);
        this.txtNombreAmigo.setText(this.amigoChatActual);
    }
    
    public void recibirMensaje(MensajeChat mc){
        this.conversaciones.get(mc.getEmisor()).add(mc);
        if(mc.getEmisor().equals(amigoChatActual)){
            actualizarChat();
        }else{
            ((ModeloTablaAmigos) this.tablaConectados.getModel()).setFilas(this.conversaciones);
        }
    }
    
    public void mostrarNumeroSolicitudes(int numeroPeticiones){
        String texto = "Solicitudes";
        if(numeroPeticiones > 0){
            texto += " (" + numeroPeticiones + ")";
        }
        this.buttonSolicitudes.setText(texto);
    }
    
    
}
