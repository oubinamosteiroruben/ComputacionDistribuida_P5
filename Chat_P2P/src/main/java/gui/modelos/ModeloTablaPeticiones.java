
package gui.modelos;

import gui.paneles.SolicitudesPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import modelos.Usuario;


public final class ModeloTablaPeticiones extends AbstractTableModel {

    private List<String> peticiones;
    
    private final SolicitudesPanel si;

    // ------------------------------------------------------------------------
    // ----------------------------- Constructor ------------------------------
    /*public ModeloTablaPeticiones() {
        this.peticiones = new ArrayList<>();
        this.si = null;
    }*/
    
    public ModeloTablaPeticiones(SolicitudesPanel si) {
        this.peticiones = new ArrayList<>();
        this.si = si;
    }

    // ------------------------------------------------------------------------
    // -------------------------- Overrides Getters ---------------------------
    @Override
    public final int getRowCount() {
        return this.peticiones.size();
    }

    @Override
    public final int getColumnCount() {
        return 1;
    }

    @Override
    public final Object getValueAt(int rowIndex, int columnIndex) {
        Object resultado=null;

        switch (columnIndex){
            case 0: resultado = this.peticiones.get(rowIndex); break;
            /*case 1: 
                    JButton buttonSi = new JButton("SI");
                    buttonSi.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            System.out.println("BOTON SI PULSADO DE " + rowIndex);
                        }
                    });
                    resultado = buttonSi; break;
            case 2: 
                    JButton buttonNo = new JButton("NO");
                    buttonNo.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            System.out.println("BOTON NO PULSADO DE " + rowIndex);
                        }
                    });
                    buttonNo.setVisible(true);
                    resultado = buttonNo; break;*/
        }
        return resultado;
    }

    @Override
    public final String getColumnName(int col) {
        String nombre = null;

        switch (col){
            case 0: nombre = "Usuario"; break;
            /*case 1: nombre = "Si"; break;
            case 2: nombre = "No"; break;*/
        }
        return nombre;
    }

    @Override
    public final Class getColumnClass(int col) {
        Class clase = null;

        switch (col){
            case 0: clase = java.lang.String.class; break;
            /*case 1: clase = JButton.class; break;
            case 2: clase = JButton.class; break;*/
        }
        return clase;
    }

    // ------------------------------------------------------------------------
    // ------------------------------ Funciones -------------------------------
    public final void setFilas(java.util.List<String> solicitudes) {
        if (solicitudes != null ) {
            this.peticiones = solicitudes;
            fireTableDataChanged();
        }
    }

    public final String obtenerPeticion(int i) {
        return this.peticiones.get(i);
    }

    public final void actualizarTabla() {
        fireTableDataChanged();
    }

    public final void nuevaSolicitud(String username) {
        this.peticiones.add(username);
        fireTableRowsInserted(this.peticiones.size() - 1, this.peticiones.size() - 1);
    }
}