/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.paneles;

/**
 *
 * @author ruben
 */
public class MainPanel_Der extends javax.swing.JPanel {

    private final MainPanel mp;
    /**
     * Creates new form MainPanel_Der
     */
    public MainPanel_Der(MainPanel mp) {
        this.mp = mp;
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitutlo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textChat = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        buttonEnviar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(330, 430));
        setMinimumSize(new java.awt.Dimension(330, 430));
        setPreferredSize(new java.awt.Dimension(330, 430));

        labelTitutlo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitutlo.setText("Nombre App");
        labelTitutlo.setName("labelTitutlo"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        textChat.setName("textChat"); // NOI18N
        jScrollPane1.setViewportView(textChat);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        txtMensaje.setColumns(20);
        txtMensaje.setLineWrap(true);
        txtMensaje.setRows(1);
        txtMensaje.setName("txtMensaje"); // NOI18N
        jScrollPane2.setViewportView(txtMensaje);

        buttonEnviar.setText("↑");
        buttonEnviar.setName("buttonEnviar"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jScrollPane1)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, labelTitutlo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buttonEnviar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .add(labelTitutlo)
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(44, 44, 44)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(buttonEnviar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelTitutlo;
    private javax.swing.JTextPane textChat;
    private javax.swing.JTextArea txtMensaje;
    // End of variables declaration//GEN-END:variables
}
