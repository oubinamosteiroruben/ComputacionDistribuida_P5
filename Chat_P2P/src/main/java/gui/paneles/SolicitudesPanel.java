/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

import static definiciones.Definiciones.CAMPOS_INCOMPLETOS;
import static definiciones.Definiciones.ERROR_NORMAL;
import gui.VUsuario;
import gui.modelos.ModeloTablaPeticiones;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ruben
 */
public class SolicitudesPanel extends javax.swing.JPanel {

    private final VUsuario vu;
    
    private ArrayList<String> peticiones;
    
    private String peticionActual;
    /**
     * Creates new form AmistadesPanel
     */
    public SolicitudesPanel(VUsuario vu) {
        this.vu = vu;
        this.peticiones = new ArrayList<>();
        this.peticiones.add("Roberto");
        initComponents();
        actualizarTablaPeticiones();
        this.buttonAceptar.setEnabled(false);
        this.buttonRechazar.setEnabled(false);
        //obtenerPeticiones();
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
        txtUsername = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPeticiones = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        txtError = new javax.swing.JLabel();
        buttonAceptar = new javax.swing.JButton();
        buttonRechazar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(542, 454));
        setMinimumSize(new java.awt.Dimension(542, 454));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Solicitudes de Amistad");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("Buscar");
        jLabel2.setName("jLabel2"); // NOI18N

        txtUsername.setName("txtUsername"); // NOI18N

        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pendientes");
        jLabel3.setName("jLabel3"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tablaPeticiones.setModel(new ModeloTablaPeticiones(this));
        tablaPeticiones.setName("tablaPeticiones"); // NOI18N
        tablaPeticiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPeticionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPeticiones);

        jButton2.setText("<");
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtError.setName("txtError"); // NOI18N

        buttonAceptar.setText("Aceptar");
        buttonAceptar.setName("buttonAceptar"); // NOI18N
        buttonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptarActionPerformed(evt);
            }
        });

        buttonRechazar.setText("Rechazar");
        buttonRechazar.setName("buttonRechazar"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtError, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(26, 26, 26)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(32, 32, 32)
                                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 320, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 330, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(layout.createSequentialGroup()
                        .add(119, 119, 119)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(layout.createSequentialGroup()
                                .add(buttonAceptar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(107, 107, 107)
                                .add(buttonRechazar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 317, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(18, 18, 18)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(43, 43, 43)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(txtUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel2))
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(txtError)
                .add(25, 25, 25)
                .add(jLabel3)
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 142, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(buttonAceptar)
                    .add(buttonRechazar))
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //enviarPeticion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.vu.mostrarMainUsuarios();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablaPeticionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPeticionesMouseClicked
        // TODO add your handling code here:
        this.buttonAceptar.setEnabled(false);
        this.buttonRechazar.setEnabled(false);
        String peticion;
        ModeloTablaPeticiones m;
        m = (ModeloTablaPeticiones) this.tablaPeticiones.getModel();
        peticion = m.obtenerPeticion(this.tablaPeticiones.getSelectedRow());
        if (peticion != null) {
            this.peticionActual = peticion;
            this.buttonAceptar.setEnabled(true);
            this.buttonRechazar.setEnabled(true);
        }
    }//GEN-LAST:event_tablaPeticionesMouseClicked

    private void buttonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptarActionPerformed
        // TODO add your handling code here:
        /*
        aceptar
        */
        this.peticiones.remove(this.tablaPeticiones.getSelectedRow());
        this.buttonAceptar.setEnabled(false);
        this.buttonRechazar.setEnabled(false);
    }//GEN-LAST:event_buttonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptar;
    private javax.swing.JButton buttonRechazar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPeticiones;
    private javax.swing.JLabel txtError;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    public void actualizarTablaPeticiones(){
        ((ModeloTablaPeticiones) tablaPeticiones.getModel()).setFilas(this.peticiones);
    }
    
    
/*
    private void enviarPeticion(){
        try{
            if(!this.txtUsername.getText().equals("")){
                this.vu.enviarPeticion(this.txtUsername.getText()); // HAY QUE PONERLE UN MENSAJE
            }else{
                txtError.setText(CAMPOS_INCOMPLETOS);
            }
        }catch(Exception e){
            txtError.setText(ERROR_NORMAL);
            System.out.println("Exception: " + e);
        }
    }
    
    public void actualizarPeticiones(ArrayList<String> peticiones){
        this.peticiones = peticiones;
    }
    
    public void actualizarTablaPeticiones(){
        ((ModeloTablaPeticiones) tablaPeticiones.getModel()).setFilas(this.peticiones);
    }
    
    public void obtenerPeticiones(){
        try{
            this.peticiones = this.vu.obtenerPeticiones();
        }catch(Exception e){
            System.out.println("Excpetion: " + e);
        }
    }*/
}