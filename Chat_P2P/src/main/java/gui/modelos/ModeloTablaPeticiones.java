
package gui.modelos;

import gui.paneles.SolicitudesPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import modelos.Usuario;


public final class ModeloTablaSolicitudes extends AbstractTableModel {

    private List<Usuario> solicitudes;
    
    private final SolicitudesPanel si;

    // ------------------------------------------------------------------------
    // ----------------------------- Constructor ------------------------------
    public ModeloTablaSolicitudes() {
        this.solicitudes = new ArrayList<>();
        this.si = null;
    }
    
    public ModeloTablaSolicitudes(List<Usuario> solicitudes, SolicitudesPanel si) {
        this.solicitudes = solicitudes;
        this.si = si;
    }

    // ------------------------------------------------------------------------
    // -------------------------- Overrides Getters ---------------------------
    @Override
    public final int getRowCount() {
        return this.solicitudes.size();
    }

    @Override
    public final int getColumnCount() {
        return 2;
    }

    @Override
    public final Object getValueAt(int rowIndex, int columnIndex) {
        Object resultado=null;

        switch (columnIndex){
            case 0: resultado = this.solicitudes.get(rowIndex).getUsername(); break;
            case 1: 
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
                    resultado = buttonNo; break;
        }
        return resultado;
    }

    @Override
    public final String getColumnName(int col) {
        String nombre = null;

        switch (col){
            case 0: nombre = "Usuario"; break;
            case 1: nombre = "Si"; break;
            case 2: nombre = "No"; break;
        }
        return nombre;
    }

    @Override
    public final Class getColumnClass(int col) {
        Class clase = null;

        switch (col){
            case 0: clase = java.lang.String.class; break;
            case 1: clase = JButton.class; break;
            case 2: clase = JButton.class; break;
        }
        return clase;
    }

    // ------------------------------------------------------------------------
    // ------------------------------ Funciones -------------------------------
    public final void setFilas(java.util.List<Usuario> solicitudes) {
        if (solicitudes != null ) {
            this.solicitudes = solicitudes;
            fireTableDataChanged();
        }
    }

    public final Usuario obtenerSolicitud(int i) {
        return this.solicitudes.get(i);
    }

    public final void actualizarTabla() {
        fireTableDataChanged();
    }

    public final void nuevaSolicitud(Usuario u) {
        this.solicitudes.add(u);
        fireTableRowsInserted(this.solicitudes.size() - 1, this.solicitudes.size() - 1);
    }
}