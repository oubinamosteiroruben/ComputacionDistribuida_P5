
package gui.modelos;

import gui.paneles.MainPanel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelos.Usuario;

public final class ModeloTablaAmigos extends AbstractTableModel {

    private List<String> amigos;
    
    private final MainPanel mp;

    // ------------------------------------------------------------------------
    // ----------------------------- Constructor ------------------------------
    public ModeloTablaAmigos() {
        this.amigos = new ArrayList<>();
        this.mp = null;
    }
    
    public ModeloTablaAmigos(List<String> amigos, MainPanel mp) {
        this.amigos = amigos;
        this.mp = mp;
    }
    
    public ModeloTablaAmigos(MainPanel mp) {
        this.amigos = new ArrayList<>();
        this.mp = mp;
    }

    // ------------------------------------------------------------------------
    // -------------------------- Overrides Getters ---------------------------
    @Override
    public final int getRowCount() {
        return this.amigos.size();
    }

    @Override
    public final int getColumnCount() {
        return 1;
    }

    @Override
    public final Object getValueAt(int rowIndex, int columnIndex) {
        Object resultado=null;

        switch (columnIndex){
            case 0: resultado = this.amigos.get(rowIndex); break;
        }
        return resultado;
    }

    @Override
    public final String getColumnName(int col) {
        String nombre = null;

        switch (col){
            case 0: nombre = "Amigos"; break;
        }
        return nombre;
    }

    @Override
    public final Class getColumnClass(int col) {
        Class clase = null;

        switch (col){
            case 0: clase = java.lang.String.class; break;
        }
        return clase;
    }

    // ------------------------------------------------------------------------
    // ------------------------------ Funciones -------------------------------
    public final void setFilas(java.util.List<String> amigos) {
        if (amigos != null ) {
            this.amigos = amigos;
            fireTableDataChanged();
        }
    }

    public final String obtenerAmigo(int i) {
        return this.amigos.get(i);
    }

    public final void actualizarTabla() {
        fireTableDataChanged();
    }

    public final void nuevoAmigo(String amigo) {
        this.amigos.add(amigo);
        fireTableRowsInserted(this.amigos.size() - 1, this.amigos.size() - 1);
    }
}